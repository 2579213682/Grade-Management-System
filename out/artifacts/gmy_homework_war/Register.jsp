<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="css/Registerstyle.css" rel="stylesheet">
    <title>注册</title>
</head>
<body>
<div class="box">
    <div class="content">
        <div class="login-wrapper">
            <div class="mask"></div>
            <div class="login-content">
                <h1>注 册</h1>
                <div class="title-text">
                    欢迎来到注册页面，成功登录注册后可进行登录
                    <p style="color: red">${tell1}</p>
                </div>
                <div class="tips">
                    <span>已有账号？</span>
                    <!--在这个的href填上登录的jsp-->
                    <a href="Login.jsp">登录</a>
                </div>
                <div class="other-login">
                </div>
                <div class="login-form">
                    <!--在这里的action填上登录用的servlet-->
                    <form id="reg-form" name="registerform" method="post"
                          action="http://localhost:8080/gmy_homework_war/Register">
                        <input type="text" class="user" placeholder="账号" name="regid" id="username">
                        <p id="text1" style="color: red"></p>
                        <input type="text" class="password" placeholder="密码" name="password" id="userpassword">
                        <input type="text" class="password" placeholder="确认密码" name="checkpassword" id="reuserpassword">
                        <p id="text2" style="color: red"></p>
                        <input class="login-btn" type="submit" value="注  册" id="register">
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    /*下面是注册的一些判断*/
    var text1 = document.getElementById("text1");
    var text2 = document.getElementById("text2");
    var register = document.getElementById("reg-form");
    var userpassword = document.getElementById("userpassword");
    var username = document.getElementById("username");
    var repassword = document.getElementById("reuserpassword");
    var b = false;
    var b1 = false;
    username.onblur = function check() {
        if (username.value.length <= 10 && username.value.length >= 1) {
            text1.innerText = "";
            b = true;
        } else {
            text1.innerText = "你输入的账号长度需在1~10";
            b = false;
        }
    }

    repassword.onblur = function check1() {
        if (userpassword.value == repassword.value) {
            text2.innerText = "";
            b1 = true;
        } else {
            text2.innerText = "你输入的密码前后不正确！";
            b1 = false;
        }
    }
    register.onsubmit = function submit() {
        if (b && b1) {
            return true;
        } else {
            return false;
        }
    }

</script>
</html>
