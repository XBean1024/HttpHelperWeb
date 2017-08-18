package com.http.servlet.user;

import com.alibaba.fastjson.JSON;
import com.http.constant.Code;
import com.http.dao.user.UserInfoDao;
import com.http.servlet.user.bean.UserBean;
import com.http.servlet.user.bean.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static com.http.constant.Constant.CHART_SET_UTF_8;
import static com.http.constant.Constant.CONTENT_TYPE;

/**
 * Created by smart on 2017/8/18.
 * function： 注册信息
 */
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);// MIME 类型
        String name = request.getParameter("name");//账号
        String password = request.getParameter("password");//密码
        String telephone = request.getParameter("telephone");//密码
        int age = Integer.parseInt(request.getParameter("age"));//年龄

        UserBean userBean = new UserBean(new String(name.getBytes("ISO8859-1"), CHART_SET_UTF_8), password, age, telephone);

        UserInfoDao userInfoDao = new UserInfoDao();
        String sql = " insert into users(name,password,age,telephone) values(?,?,?,?)";
        int count = userInfoDao.insert(userBean, sql);
        UserInfo userLoginInfo = new UserInfo();
        if (count != 0) {//注册成功
            userLoginInfo.setUserLoginInfo(Code.CODE_REGISTER_SUCCESS, Code.INFO_REGISTER_SUCCESS);
        } else {
            userLoginInfo.setUserLoginInfo(Code.CODE_REGISTER_ERROR, Code.INFO_REGISTER_ERROR);
        }
        byte[] jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(jsonBytes);//输出响应数据
        outputStream.flush();
        outputStream.close();
    }
}
