package com.http.dao.user;

import com.http.dao.user.bean.UserBean;
import com.http.dao.user.bean.UserLoginInfo;
import com.http.constant.Code;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.http.dao.user.util.UtilUserInfo.*;
import static com.http.util.Util.logInfo;

/**
 * Created by smart on 2017/8/3.
 * function：对用户信息的 CRUD 操作
 */
public class UserInfoDao implements IUserInfo {
    @Override
    public int insert(UserBean userBean) {
        String sql = " insert into users(name,password,age,telephone) values(?,?,?,?)";
        return add(sql, userBean);
    }

    @Override
    public void delete(String account) {

    }

    @Override
    public int update(UserBean userBean) {
        String sql = " update users " + " set name = ? , " + " password = ? , "
                + " age= ? " + " where name= " + userBean.getName();
        logInfo(sql);
        return modify(sql, userBean);

    }

    @Override
    public UserLoginInfo select(String name, String password) {
        ResultSet resultSet = query(name);
        UserLoginInfo userLoginInfo = new UserLoginInfo();
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
