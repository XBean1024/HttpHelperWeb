<%--
  Created by IntelliJ IDEA.
  User: smart
  Date: 2017/8/17
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="static com.http.constant.Constant.userPasswd" %>
<%@ page import="static com.http.constant.Constant.url" %>
<%@ page import="static com.http.constant.Constant.userName" %>
<% String driver = "com.mysql.jdbc.Driver";
    try {

        // 1 加载驱动程序

        Class.forName(driver);

        // 2 连接数据库

        Connection conn = DriverManager.getConnection(url, userName, userPasswd);
        // 3 用来执行SQL语句

        Statement statement = conn.createStatement();

        // 要执行的SQL语句

        String sql = "select * from users";

        ResultSet rs = statement.executeQuery(sql);
        String name = null;
        String mima=null;
        while (rs.next()) {
            name = rs.getString("name");
            mima = rs.getString("password");
            out.println(name+"\t"+mima);
        }
        rs.close();
        conn.close();
    } catch (ClassNotFoundException e) {
        System.out.println("Sorry,can`t find the Driver!");
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
