# HttpHelperWeb
:fire:用于测试安卓网络请求框架而创建的web工程
![](https://github.com/Xbean1024/HttpHelperWeb/blob/master/gif/login_register.gif)
![](https://github.com/Xbean1024/HttpHelperWeb/blob/master/gif/data.png)
### 日志：
2017/8/10 17:21:20 
###  上传数据库  数据结构
![](https://github.com/Xbean1024/HttpHelperWeb/blob/master/gif/db.png)
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
<form name="atool_alipay_img_form" style="padding-bottom: 0;border:none;" method="post" action="https://shenghuo.alipay.com/send/payment/fill.htm" target="_blank" accept-charset="GBK" onsubmit="document.charset='gbk';"><input type="hidden" value="18221869775" name="optEmail"> <input type="hidden" name="title" placeholder="付款说明" value=""> <input type="image" value="支付宝收款" src="http://www.atool.org/res/alipay_1.png" name="pay"></form>

<form name="atool_alipay_text_form" style="padding-bottom: 0;border:none;" method="post" action="https://shenghuo.alipay.com/send/payment/fill.htm" target="_blank" accept-charset="GBK" onsubmit="document.charset='gbk';"><input type="hidden" value="18221869775" name="optEmail"> <input type="hidden" value="1000" name="payAmount"> <input type="hidden" name="title" placeholder="付款说明" value=""> [向我捐款](javascript:javascript:document.atool_alipay_text_form.submit(); "支付宝收款")</form>

