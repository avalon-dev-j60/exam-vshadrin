/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mysite.servlets;

import edu.mysite.beans.AuthService;
import static edu.mysite.util.RedirectHelper.redirectBack;
import static edu.mysite.util.RedirectHelper.redirectLocaly;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vasha
 */
@WebServlet("/signgout")
public class SignoutServlet extends HttpServlet {
    
    @Inject AuthService authService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authService.isAuth()) {
            authService.setAuth(false);
            redirectBack(request, response);
        } else {
            redirectLocaly(request, response, "/login");
        }
    }
}
