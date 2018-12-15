package org.nick.java;

import org.nick.java.dao.ToDo;
import org.nick.java.dao.User;
import org.nick.java.services.ToDoService;
import org.nick.java.services.UserAuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/todo.do")
public class ToDoServlet extends HttpServlet {


    private ToDoService toDoService = new ToDoService();
    private UserAuthenticationService userAuthenticationService = new UserAuthenticationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
          String description = request.getParameter("todo");
          System.out.println((String)request.getSession().getAttribute("username"));
          User user = UserAuthenticationService.getUserByUsername((String)request.getSession().getAttribute("username"));
          System.out.println(user.getId() +" is the id ");
          toDoService.addTodo(description, user.getId());
          List<ToDo> toDoList = toDoService.retrieveToDos((String)request.getSession().getAttribute("username"));
          request.setAttribute("todolist",toDoList);
        try {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
