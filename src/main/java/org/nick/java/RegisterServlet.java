package org.nick.java;

import org.nick.java.services.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

    private RegisterService registerService = new RegisterService();

    public static final String notsamepass = "Password not same in the confirmation ";
    public static final String mandatoryFieldsNotFilled = "All mandatory fields should be filled";
    public static final String usermaneAlreadyExists = "Username already exists ";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String email    = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordconfirmation = req.getParameter("passwordconfirmation");

        if( (username.equals("") || username == null) || (email.equals("") || email == null) || (password.equals("") || password == null) ||
                (passwordconfirmation.equals("") || passwordconfirmation == null)){
            req.setAttribute("failureMsg",mandatoryFieldsNotFilled);
            req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
        }

        if(!password.equals(passwordconfirmation)){
            req.setAttribute("failureMsg",notsamepass);
            req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
        }
        String result = registerService.registerUser(username,password);
        if(result.equals("success")){
            req.setAttribute("successMsg","username "+username+" was successfully created");
        }
        else{
            req.setAttribute("failureMsg",result);
        }
        req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);



    }
}
