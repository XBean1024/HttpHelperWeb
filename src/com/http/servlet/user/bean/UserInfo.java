package com.http.servlet.user.bean;

public class UserInfo {

    private String mMsg;//用户登反馈信息描述
    private String mCode;//登录反馈信息码

    public void setUserLoginInfo(String pErrorCode, String pMsg) {
        mCode = pErrorCode;
        mMsg = pMsg;
    }

    public String getMsg() {
        return mMsg;
    }

    public String getCode() {
        return mCode;
    }
}
