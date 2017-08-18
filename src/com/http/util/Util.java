package com.http.util;

import com.alibaba.fastjson.JSON;
import com.http.servlet.user.bean.UserInfo;
import com.sun.istack.internal.Nullable;

import java.io.IOException;
import java.io.OutputStream;

import static com.http.constant.Constant.CHART_SET_UTF_8;

/**
 * Created by smart on 2017/8/3.
 */
public class Util {
    private static boolean log  = true;
    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
    public static void logInfo(String msg){
        if (log) {
            System.out.println(msg);
        }
    }

    public static void emptyParams(OutputStream outputStream, String errorCode, String errorInfo) throws IOException {
        UserInfo userLoginInfo;
        byte[] jsonBytes;
        userLoginInfo = new UserInfo();
        userLoginInfo.setUserLoginInfo(errorCode, errorInfo);
        jsonBytes = JSON.toJSONString(userLoginInfo).getBytes(CHART_SET_UTF_8);
        outputStream.write(jsonBytes);
        outputStream.flush();
        outputStream.close();
    }
}
