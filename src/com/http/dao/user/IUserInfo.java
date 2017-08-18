package com.http.dao.user;

import com.http.servlet.user.bean.UserBean;
import com.http.servlet.user.bean.UserInfo;

/**
 * Created by smart on 2017/8/3.
 */
public interface IUserInfo {
    /** 向数据库增加一条记录
     * @param userBean 用户
     * @param sql
     */
    int insert(UserBean userBean, String sql);

    /** 删除用账户
     * @param account 账户名
     */
    void delete(String account);

    /** 更新账户信息
     * @param userBean 用户
     *
     */
    int update(UserBean userBean);

    /** 查询数据
     * @param account
     * @param password
     * @param columnLabel
     */
    UserInfo select(String account, String password, String columnLabel);
}
