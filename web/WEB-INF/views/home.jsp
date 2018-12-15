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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Home Page</title>
</head>
<body>
  <h1>Welcome ${name}</h1> <br/>
  <p>This is the list of your TO-DOs</p>
  <p>To Do List</p>
  <ol>
      <c:forEach items="${todolist}" var="todo">
          <li>${todo.description}
          <a href="/TestApp/delete-todo.do?description=${todo.description}">
              <span class="glyphicon glyphicon-remove"></span>
          </a>
          </li>
      </c:forEach>

  </ol>
<form action="/TestApp/todo.do" method="post">
    <input type="text" name="todo"/> <input type="submit" value="Add"/>
</form>
</body>
</html>
