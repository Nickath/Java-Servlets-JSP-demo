<%--
  Created by IntelliJ IDEA.
  User: NICK
  Date: 12/8/2018
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
   <h1>Login</h1>

    <form action="/TestApp/login.do" method="post">
        Enter your name <input type="text" name="name"/><br/>
        Enter your password <input type="password" name="password"/><br/>
        <input type="submit" value="Login" name="login"/>

    </form>
    <p><font color="red"> ${errorMsg}</font> </p>
    <p>Don't you have an account? <a href="/TestApp/register.do">register here</a> </p>
</body>
</html>
