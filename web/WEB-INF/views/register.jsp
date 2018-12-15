<%--
  Created by IntelliJ IDEA.
  User: NICK
  Date: 12/15/2018
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register for Account</title>
</head>
<body>
<body>
<h1>Register</h1>

<form action="/TestApp/register.do" method="post">
    Enter your name* <input type="text" name="name"/><br/>
    Enter your email* <input type="text" name="email"/><br/>
    Enter your password* <input type="password" name="password"/><br/>
    Password confirmation* <input type="password" name="passwordconfirmation"/><br/>
    <input type="submit" value="Register" name="register"/>

</form>
<p><font color="red"> ${failureMsg}</font> </p>
<p><font color="green"> ${successMsg}</font> </p>

<p>Already have an account? <a href="/TestApp/login.do">login</a> </p>
</body>
</body>
</html>
