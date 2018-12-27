package com.http.servlet.user;

import com.alibaba.fastjson.JSON;
import com.http.constant.Code;
import com.http.dao.user.UserInfoDao;
import com.http.servlet.user.bean.UserBean;
import com.http.servlet.user.bean.UserInfo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.http.constant.Constant.*;
import static com.http.dao.util.UtilUserInfo.query;
import static com.http.util.Util.logInfo;

/**
 * Created by smart on 2017/8/18.
 * function： 修改、更新用户信息
 */
public class ModifyServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        logInfo("修改");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);// MIME 类型
        String name = request.getParameter("name");//账号
        String password = request.getParameter("password");//密码
        String telephone = request.getParameter("telephone");//手机号
        try {
            UserBean userBean = new UserBean(new String(name.getBytes(CHART_SET_ISO_8859_1), CHART_SET_UTF_8), password, telephone);

            UserInfo userInfo = modify(userBean);
            logInfo(userInfo.getMsg());
            byte[] jsonBytes = JSON.toJSONString(userInfo).getBytes(CHART_SET_UTF_8);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(jsonBytes);//输出响应数据
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private UserInfo modify(UserBean userBean) {
        //查询手机号是否正确
        logInfo(userBean.getName());
        ResultSet resultSet = query(userBean.getName());//得到结果集
        //遍历结果集
        UserInfo userInfo = new UserInfo();
        try {
            if (resultSet.next()) {
                if (!userBean.getTelephone().equals(resultSet.getString("telephone"))) {
                    userInfo.setUserLoginInfo(Code.CODE_PHONE_ERROR, Code.INFO_PHONE_ERROR);
                } else {
                    //去更新
                    UserInfoDao dao = new UserInfoDao();
                    int count = dao.update(userBean);
                    if (count == 0) {
                        userInfo.setUserLoginInfo(Code.CODE_UPDATE_PASSWORD_ERROR, Code.INFO_UPDATE_PASSWORD_ERROR);
                    }else {
                        userInfo.setUserLoginInfo(Code.CODE_UPDATE_PASSWORD_SUCCESS, Code.INFO_UPDATE_PASSWORD_SUCCESS);
                    }
                }
            }else {
                userInfo.setUserLoginInfo(Code.CODE_ACCOUNT_NOT_EXIST, Code.INFO_ACCOUNT_NOT_EXIST);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
