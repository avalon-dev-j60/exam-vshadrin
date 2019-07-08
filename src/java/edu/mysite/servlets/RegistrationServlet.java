
package edu.mysite.servlets;

import edu.mysite.beans.AuthService;
import edu.mysite.models.Credentials;
import edu.mysite.models.User;
import edu.mysite.services.UserServiceLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    
    @Inject AuthService authService;
    @EJB UserServiceLocal userService;
    
   static final String JSP = "/WEB-INF/pages/registration.jsp";
   
   private void redirect(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
        response.setHeader("Location", location);
        response.setStatus(302);
   }
   
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authService.isAuth()) {String referer = request.getHeader("Referer"); if (referer == null) {referer = request.getContextPath();}
            redirect(request, response, referer);
        } else {
            request .getRequestDispatcher(JSP).forward(request, response);
        }
    }
    
    private void validateParameters(String login, String password, String confirmation) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalStateException("Login is required!");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalStateException("Password is required!");
        }
        if (confirmation == null || confirmation.trim().isEmpty()) {
            throw new IllegalStateException("Password confirmation is required!");
        }
        if (!password.equals(confirmation)) {
            throw new IllegalStateException("Password does not match confirmation!");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
        try {validateParameters(login,password,confirmation);
            Credentials credentials = new Credentials(login, password);
            User user = new User(login, credentials);
            userService.create(user);
            redirect(request, response, request.getContextPath() + "/singin");
        } catch (IllegalStateException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
}
