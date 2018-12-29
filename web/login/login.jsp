<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="static com.http.util.Util.logInfo" %>
<%@ page import="static com.http.constant.Code.CODE_LOGIN_SUCCESS" %>
<%@ page import="com.http.dao.user.UserInfoDao" %>
<%@ page import="com.http.servlet.user.bean.UserInfo" %>
<%@ page import="com.http.util.Util" %>
<%@ page import="java.util.Date" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>登录jsp</title>
    <link type="text/css" rel="stylesheet" href="./login/css/style.css">

    <script type="text/javascript" src="./js/user/login.js"></script>
</head>

<body>

<%
    UserInfoDao userInfoDao = new UserInfoDao();
    UserInfo userLoginInfo;
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    logInfo(name);
    logInfo(password);
    if (Util.isEmpty(name)) {
        out.print("<script>alert(Code.INFO_ACCOUNT_ERROR); </script>");
        return;
    }
    if (Util.isEmpty(password)) {
        out.print("<script>alert(Code.INFO_PASSWORD_ERROR); </script>");
        return;
    }
    userLoginInfo = userInfoDao.select(name, password, "");
    //转发
    logInfo("检查结果：" + userLoginInfo.getCode());
    if (userLoginInfo.getCode().equals(CODE_LOGIN_SUCCESS)) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/upload/upload.jsp");
        dispatcher.forward(request, response);
    } else {
        logInfo(userLoginInfo.getMsg());
        out.print("<script>alert(userLoginInfo.getMsg()); </script>");
    }
    Date date = new Date();
    out.print(date);
%>
<div class="container">

    <div id="login">

        <h2><span class="fontawesome-lock"></span>用户登录</h2>
        <!--servlet 就在项目的根目录下-->
        <form action="UserServlet" method="POST" id="login_form">

            <fieldset>

                <p><label for="account">Account</label></p>
                <p><input type="text" id="account" name="name" placeholder="请输入账号"
                          style="background: cornsilk;width: 200px;height: 30px"></p>

                <p><label for="password">Password</label></p>
                <p><input type="password" id="password" name="password" placeholder="请输入密码"
                          style="width: 200px;height: 30px"></p>

                <p><input type="submit" value="登录"></p>

            </fieldset>

        </form>

    </div> <!-- end login -->

</div>
</body>
</html>