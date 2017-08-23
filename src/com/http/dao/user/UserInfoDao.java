package com.http.dao.user;

import com.http.dao.util.UtilUserInfo;
import com.http.servlet.user.bean.UserBean;
import com.http.servlet.user.bean.UserInfo;
import com.http.constant.Code;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.http.dao.util.UtilUserInfo.*;
import static com.http.util.Util.logInfo;

/**
 * Created by smart on 2017/8/3.
 * function：对用户信息的 CRUD 操作
 */
public class UserInfoDao implements IUserInfo {
    @Override
    public int insert(UserBean userBean, String sql) {
        return UtilUserInfo.add(sql, userBean);
    }

    @Override
    public void delete(String account) {

    }

    @Override
    public int update(UserBean userBean) {
        String sql = " update users " + " set name = ? , " + " password = ? , "
                             + " age= ? " + " where name= " + userBean.getName();
        return UtilUserInfo.update(sql, userBean);
    }

    @Override
    public UserInfo select(String name, String password, String columnLabel) {
        ResultSet resultSet = query(name);
        UserInfo userLoginInfo = new UserInfo();
        try {
            if (resultSet.next()) {
                logInfo("数据校验！" + resultSet.getString("password"));
                if (!password.equals(resultSet.getString("password"))) {
                    userLoginInfo.setUserLoginInfo(Code.CODE_PASSWORD_ERROR, Code.INFO_PASSWORD_ERROR);
                } else {
                    userLoginInfo.setUserLoginInfo(Code.CODE_LOGIN_SUCCESS, Code.INFO_LOGIN_SUCCESS);
                }
            } else {
                logInfo("账号不存在");
                userLoginInfo.setUserLoginInfo(Code.CODE_ACCOUNT_NOT_EXIST, Code.INFO_ACCOUNT_NOT_EXIST);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userLoginInfo;
    }

}
