
package edu.mysite.servlets;

import edu.mysite.beans.AuthService;
import edu.mysite.models.Credentials;
import edu.mysite.models.User;
import edu.mysite.services.UserServiceLocal;
import static edu.mysite.util.RedirectHelper.redirectBack;
import static edu.mysite.util.RedirectHelper.redirectLocaly;
import static edu.mysite.util.ValidationHelper.requireEquals;
import static edu.mysite.util.ValidationHelper.requireNonEmpty;
import static edu.mysite.util.ValidationHelper.requireNonNull;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import javax.xml.bind.ValidationException;

@WebServlet (urlPatterns = "/singin")
public class SigninServlet extends HttpServlet{
    
     private static final String JSP = "/WEB-INF/pages/singin.jsp";
    
     @Inject AuthService authService;
    
    @EJB UserServiceLocal userService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authService.isAuth()) {
            redirectBack(request, response);
        } else {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher(JSP);
            dispatcher.forward(request, response);
        }
    }
      
    
      
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            requireNonEmpty(login, "Логин обязателен для ввода");
            requireNonEmpty(password, "Пароль обязателен для ввода");
            User user = userService.find(login);
            requireNonNull(user, "Такого пользователя не существует");
            Credentials credentials = new Credentials(login, password);
            requireEquals(credentials, user.getCredentials(), "Пароль не верен");
            authService.setAuth(true);
            redirectLocaly(request, response, "/");
        } catch (ValidationException e) {request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
}
