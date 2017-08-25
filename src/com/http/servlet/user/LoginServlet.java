package com.http.servlet.user;

import com.alibaba.fastjson.JSON;
import com.http.constant.Code;
import com.http.dao.user.UserInfoDao;
import com.http.servlet.user.bean.UserInfo;
import com.http.util.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static com.http.constant.Code.CODE_LOGIN_SUCCESS;
import static com.http.constant.Code.COLUMN_LABEL_PASSWORD;
import static com.http.constant.Constant.*;
import static com.http.util.Util.emptyParams;
import static com.http.util.Util.logInfo;

/**C:\HttpHelperWeb\web\video\demo.mp4
 * Created by smart on 2017/8/4.
 * function： 处理用户信息的 类
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);// MIME 类型

        String name = request.getParameter("name");//账号
        String password = request.getParameter("password");//密码
        String platform = request.getParameter("platform");//平台  PC或者手机

        name = new String(name.getBytes("ISO8859-1"), CHART_SET_UTF_8);//解决中文乱码
        logInfo("账号 ：" + name);
              /*参数取值检查*/
        if (Util.isEmpty(name)) {
            OutputStream outputStream = response.getOutputStream();
            emptyParams(outputStream, Code.CODE_ACCOUNT_ERROR, Code.INFO_ACCOUNT_ERROR);
            return;
        }
        if (Util.isEmpty(password)) {
            OutputStream outputStream = response.getOutputStream();
            emptyParams(outputStream, Code.CODE_PASSWORD_ERROR, Code.INFO_PASSWORD_ERROR);
            return;
        }
        if (!Util.isEmpty(platform)) {
            UserInfoDao userInfoDao = new UserInfoDao();//业务类
            UserInfo userInfo;
            byte[] jsonBytes;
            logInfo("客户端类型 ：" + platform);
            userInfo = userInfoDao.select(name, password, COLUMN_LABEL_PASSWORD);
            switch (platform) {
                case PLATFORM_MOBILE_PHONE: {
                    jsonBytes = JSON.toJSONString(userInfo).getBytes(CHART_SET_UTF_8);
                    OutputStream outputStream = response.getOutputStream();
                    outputStream.write(jsonBytes);//输出响应数据
                    outputStream.flush();
                    outputStream.close();
                    break;
                }
                case PLATFORM_PC:
                    if (userInfo.getCode().equals(CODE_LOGIN_SUCCESS)) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/upload/upload.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        log(userInfo.getMsg());
                        jsonBytes = JSON.toJSONString(userInfo).getBytes(CHART_SET_UTF_8);
                        OutputStream outputStream = response.getOutputStream();
                        outputStream.write(jsonBytes);//输出响应数据
                        outputStream.flush();
                        outputStream.close();
                    }
                    break;
            }
        }

    }
}
