package com.http.servlet.user;

import com.http.dao.user.UserInfoDao;
import com.http.dao.user.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by smart on 2017/8/7.
 * function：
 */
public interface IUser {

    /**
     * 登录
     * @param request
     * @param response
     */
    void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    /**
     * 注册
     * @param outputStream
     * @param userBean
     * @param userInfoDao
     * @param jsonBytes
     */
    void register(OutputStream outputStream, UserBean userBean, UserInfoDao userInfoDao, byte[] jsonBytes) throws IOException;

    /**
     * 更新用户信息
     */
    void update();
}
