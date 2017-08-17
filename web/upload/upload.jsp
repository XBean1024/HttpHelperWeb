<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>文件上传</title>
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
            background: #fff;
            color: #fff;
            font-family: Arial,serif;
            font-size: 12px;
        }
        .body {
            position: absolute;
            margin: 0; /* 最好将 body 元素的边距和填充设置为 0 以覆盖不同的浏览器默认值 */
            padding: 0;
            width: 100%;
            height: 100%;
            background-image: url(http://ginva.com/wp-content/uploads/2012/07/city-skyline-wallpapers-008.jpg);
            background-size:100%;
            z-index: 0;
        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<body>

    <%--${pageContext.request.contextPath}等价于<%=request.getContextPath()%>
        或者可以说是<%=request.getContextPath()%>的EL版；
        意思就是取出部署的应用程序名或者是当前的项目名称 ,比如我的项目名称是ajax01 ;
        在浏览器中输入为http://localhost:8080/ajax01/login.jsp;
        ${pageContext.request.contextPath}或<%=request.getContextPath()%>取出来的就是/ajax01,
        而"/"代表的含义就是http://localhost:8080 ;
        所以我们项目中应该这样写${pageContext.request.contextPath}/login.jsp--%>
    <form class="body" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data"
          method="post">
        上传用户：<input type="text" name="username" title="用户名"><br/>
        上传文件1：<input type="file" name="file1"><br/>
        上传文件2：<input type="file" name="file2"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>