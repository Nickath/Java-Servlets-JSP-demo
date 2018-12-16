package org.nick.java;

import org.nick.java.dao.ToDo;
import org.nick.java.services.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home.do")
public class HomeServlet extends HttpServlet {

    private ToDoService toDoService = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = (String)req.getSession().getAttribute("username");
            List<ToDo> toDoList = toDoService.retrieveToDos(username);
            req.setAttribute("todolist",toDoList);
            req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
