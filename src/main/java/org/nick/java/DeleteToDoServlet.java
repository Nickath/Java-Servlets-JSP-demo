package org.nick.java;

import org.nick.java.dao.ToDo;
import org.nick.java.dao.User;
import org.nick.java.services.ToDoService;
import org.nick.java.services.UserAuthenticationService;
import org.nick.java.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteToDoServlet extends HttpServlet {

    private UserService userService = new UserService();
    private ToDoService toDoService = new ToDoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String descriptionToBeDeleted = req.getParameter("description");
        User user = UserAuthenticationService.getUserByUsername((String)req.getSession().getAttribute("username"));
        toDoService.deleteToDo(descriptionToBeDeleted,user.getId());
        List<ToDo> toDoList = toDoService.retrieveToDos((String)req.getSession().getAttribute("username"));
        req.setAttribute("todolist",toDoList);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }
}
