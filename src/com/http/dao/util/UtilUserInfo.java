package com.http.dao.util;

import com.http.servlet.user.bean.UserBean;
import com.http.dao.connect.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.http.util.Util.logInfo;

/**
 * Created by smart on 2017/8/4.
 * function： 工具类，对 用户信息的 dao 操作
 */
public class UtilUserInfo {

    public static int add(String sql, UserBean userBean) {

        // 连接数据库 保持连接
        Connection con = DBConnection.getConnection();
        // 增加用prepareStatement
        PreparedStatement pstmt = null;
        try {
            //组装sql 语句
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userBean.getName());
            pstmt.setString(2, userBean.getPassword());
            pstmt.setInt(3, userBean.getAge());
            pstmt.setString(4, userBean.getTelephone());
            logInfo("手机号为 : "+userBean.getTelephone());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.closeConnection();
        }
        return 0;
    }

    public static int modify(String sql, UserBean userBean) {
        return add(sql, userBean);
    }

    public static ResultSet query(String name) {

        String sql = "select * from users where name='" + name + "'";
        logInfo(sql);
        // 连接数据库 保持连接
        Connection con = DBConnection.getConnection();
        // 增加用prepareStatement
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            pstmt = con.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
