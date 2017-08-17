package com.http.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
     * @param request
     * @param response
     */
    void register(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 更新用户信息
     * @param request
     * @param response
     */
    void update(HttpServletRequest request, HttpServletResponse response);
}
