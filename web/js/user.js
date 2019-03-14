/*
* 用户登录或注册
* */
var ACCOUNT = "account";//账号
var PASSWORD = "password";//密码
function login() {
    alert("登录");

    //隐藏注册表单
    document.home_login.style.display = 'block';
    document.home_register.style.display = 'none';
    const account = document.getElementById(ACCOUNT).value;
    const password = document.getElementById(PASSWORD).value;
    alert(account);
    alert(password);

}

function register() {
    alert("注册");
    //获取登录表单
    //获取账号控件
    document.home_login.style.display = 'none';
    document.home_register.style.display = 'block';
    const account = document.getElementById('account_reg');
    alert(account.value);
}

function to_register() {
    alert("去注册");
    //获取登录表单
    //获取账号控件
    document.home_login.style.display = 'none';
    document.home_register.style.display = 'block';
    const account = document.getElementById('account_reg');
    alert(account.value);
}