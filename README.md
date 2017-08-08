# HttpHelperWeb
:fire:用于测试安卓网络请求框架而创建的web工程
![](https://github.com/Xbean1024/HttpHelperWeb/blob/master/gif/login_register.gif)
![](https://github.com/Xbean1024/HttpHelperWeb/blob/master/gif/data.png)
### 日志：
2017/8/8 13:27:53 
### 1、post 请求，支持多文件上传 

2017/8/4 19:13:44  

###  1、选择表 

    user tablename; 

###  2、修改表中的字段的字符集 

    mysql> alter table users modify user_account varchar(20) character set utf8; 
###  3、Android网络编程之使用get方式向服务端提交数据和乱码问题的解决 

    //提交的数据需要进行URL编码，字母和数字编码后都不变 
    String path = "http://192.168.252.1:8080/web/LoginServlet?name="+URLEncoder.encode(name)+"&password="+pass;
      

## QQ：交流群 ：192268854
![](https://github.com/Xbean1024/XHttp/blob/master/gif/QQ.JPG)

