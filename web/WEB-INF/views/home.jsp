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
    <style>
        .footer{
            position: absolute;
            bottom:0;
            width: 100%;
            height: 60px;
        }
    </style>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>Home Page</title>
</head>
<body>
<jsp:include page="components/header.jsp" />
<div class="container">
      <h1>Welcome ${name}</h1> <br/>
      <p>This is the list of your TO-DOs</p>
      <p>To Do List</p>
      <ol>
          <c:forEach items="${todolist}" var="todo">
              <li>${todo.description}
              <a href="/TestApp/delete-todo.do?description=${todo.description}">
                  x
              </a>
              </li>
          </c:forEach>

      </ol>
    <form action="/TestApp/todo.do" method="post">
        <input type="text" name="todo"/> <input type="submit" value="Add"/>
    </form>
</div>
<jsp:include page="components/footer.jsp" />
</body>
</html>
