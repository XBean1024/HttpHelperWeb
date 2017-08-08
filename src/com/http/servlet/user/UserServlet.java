package com.http.servlet.user;

import com.alibaba.fastjson.JSON;
import com.http.constant.Code;
import com.http.dao.user.UserInfoDao;
import com.http.dao.user.bean.UserBean;
import com.http.dao.user.bean.UserLoginInfo;
import com.http.util.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static com.http.constant.Constant.*;
import static com.http.util.Util.logInfo;

/**
 * Created by smart on 2017/8/4.
 * function： 处理用户信息的 类
 */
public class UserServlet extends HttpServlet implements IUser {
    private static final long serialVersionUID = 1L;


    public void init() throws ServletException {
        log("init！！！！！！！！！！！！！！！");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("init 2 ！！！！！！！！！！！！！！！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);// MIME 类型
        String tag = request.getParameter("tag");
        if (tag == null) {
            tag = getInitParameter("tag");
        }
        logInfo(tag);
        switch (tag) {
            case TAG_LOGIN:
                login(request, response);
                break;
            case TAG_REGISTER:
                //新增
//                int age = Integer.parseInt(request.getParameter("age"));//年龄
//                UserBean userBean = new UserBean(account,password,age);

                break;
            case TAG_DELETE:
                //删除
                break;
            case TAG_UPDATE:
                //更新
                break;
        }

    }

    private void emptyParams(OutputStream outputStream, String errorCode, String errorInfo) throws IOException {
        UserLoginInfo userLoginInfo;
        byte[] jsonBytes;
        userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserLoginInfo(errorCode, errorInfo);
        jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
        outputStream.write(jsonBytes);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String account = request.getParameter("account");//账号
        String password = request.getParameter("password");//密码
        String platform = request.getParameter("platform");


        log(account);
        log(password);
        log(platform);
              /*参数取值检查*/
        if (Util.isEmpty(password)) {
            OutputStream outputStream = response.getOutputStream();
            emptyParams(outputStream, Code.CODE_PASSWORD_ERROR, Code.INFO_PASSWORD_ERROR);
            return;
        }
        if (Util.isEmpty(account)) {
            OutputStream outputStream = response.getOutputStream();
            emptyParams(outputStream, Code.CODE_ACCOUNT_ERROR, Code.INFO_ACCOUNT_ERROR);
            return;
        }


        if (!Util.isEmpty(platform)) {
            UserInfoDao userInfoDao = new UserInfoDao();//业务类
            UserLoginInfo userLoginInfo;
            byte[] jsonBytes = null;
            switch (platform) {
                case PLATFORM_MOBILE_PHONE: {
                    userLoginInfo = userInfoDao.select(account, password);
                    log(userLoginInfo.getMsg());
                    jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
                    OutputStream outputStream = response.getOutputStream();
                    outputStream.write(jsonBytes);//输出响应数据
                    outputStream.flush();
                    outputStream.close();
                    break;
                }
                case PLATFORM_PC:
                    //转发
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/upload/upload.jsp");
                    dispatcher.forward(request, response);
                    break;
                default: {
                    userLoginInfo = new UserLoginInfo();
                    userLoginInfo.setUserLoginInfo(Code.CODE_PLATFORM_ERROR,Code.INFO_PLATFORM_ERROR);
                    OutputStream outputStream = response.getOutputStream();
                    jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
                    outputStream.write(jsonBytes);//输出响应数据
                    outputStream.flush();
                    outputStream.close();
                    break;
                }
            }
        }
    }

    @Override
    public void register(OutputStream outputStream, UserBean userBean, UserInfoDao userInfoDao, byte[] jsonBytes) throws IOException {
        logInfo(userBean.getName());
        int count = userInfoDao.insert(userBean);
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        if (count != 0) {//注册成功
            userLoginInfo.setUserLoginInfo(Code.CODE_REGISTER_SUCCESS, Code.INFO_REGISTER_SUCCESS);
        } else {
            userLoginInfo.setUserLoginInfo(Code.CODE_REGISTER_ERROR, Code.INFO_REGISTER_ERROR);
        }
        jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
        outputStream.write(jsonBytes);//输出响应数据
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void update() {

    }
}
