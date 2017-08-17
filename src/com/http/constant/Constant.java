package com.http.constant;

/**
 * Created by smart on 2017/8/2.
 * function：
 */
public class Constant {
    public static final String HOST = "http://localhost:8080/HttpHelperWeb/video/demo.mp4";
    public static final String CHART_SET_UTF_8 = "UTF-8";
    public static final String CHART_SET_ISO_8859_1 = "iso-8859-1";
    public static final String CONTENT_TYPE = "text/html; charset=utf-8";

    public static final String TAG_REGISTER = "0";
    public static final String TAG_LOGIN = "3";
    public static final String TAG_DELETE = "1";
    public static final String TAG_UPDATE = "2";


    public static final String PLATFORM_MOBILE_PHONE = "mobile_phone";
    public static final String PLATFORM_PC = "pc";


    // 驱动程序名
    public static String driverName = "com.mysql.jdbc.Driver";
    // 数据库用户名
    public static String userName = "root";
    // 密码 1
    public static String userPasswd = "1228";
    // 数据库名
    public static String dbName = "http_helper_web";
    // 联结字符串
    public static String url = "jdbc:mysql://localhost/" + dbName + "?user="
                                        + userName + "&password=" + userPasswd
                                        + "&useUnicode=true&characterEncoding=utf-8";

}
