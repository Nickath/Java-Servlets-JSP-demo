<%--
  Created by IntelliJ IDEA.
  User: NICK
  Date: 12/8/2018
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
  <h1>Welcome ${name}</h1> <br/>
  <p>This is the list of your TO-DOs</p>
  <p>To Do List</p>
  <ol>
      <c:forEach items="${todolist}" var="todo">
          <li>${todo.description}</li>
      </c:forEach>

  </ol>
<form action="/todo.do" method="post">
    <input type="text" name="todo"/> <input type="submit" value="Add"/>
</form>
</body>
</html>
