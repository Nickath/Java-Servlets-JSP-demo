package org.nick.java;

import org.nick.java.dao.ToDo;
import org.nick.java.services.ToDoService;
import org.nick.java.services.UserAuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private ToDoService toDoService = new ToDoService();

    //get the login page
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //post a login attempt
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        if(UserAuthenticationService.isUserValid(username,password)){
            try {
                request.getSession().setAttribute("username", username);
                response.sendRedirect("/TestApp/home.do");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                request.setAttribute("errorMsg","Invalid Creds, try again");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
