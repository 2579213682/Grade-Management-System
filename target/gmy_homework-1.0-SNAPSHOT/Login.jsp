<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="css/Loginstyle.css" rel="stylesheet">
    <title>登录</title>
</head>
<body>
<div class="box">
    <div class="content">
        <div class="login-wrapper">
            <div class="mask"></div>
            <div class="login-content">
                <h1>登 录</h1>
                <div class="title-text">
                    欢迎来到登录页面，成功登录系统后可进行相应操作。
                    <p style="color: red">${tell}</p>
                </div>
                <div class="other-login">
                </div>
                <div class="login-form">
                    <!--在这里的action填上登录用的servlet-->
                    <form name="login" method="post" action="http://localhost:8080/Sams_homework_war/Login">
                        <input type="text" class="user" placeholder="账号" name="id">
                        <input type="password" class="password" placeholder="密码" name="password">
                        <input class="login-btn" type="submit" value="登  录">
                    </form>

                </div>
                <div class="tips">
                    <span>还没有账号?</span>
                    <!--在这个的href填上注册的jsp-->
                    <a href="Register.jsp">注册</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>

</script>
</html>
