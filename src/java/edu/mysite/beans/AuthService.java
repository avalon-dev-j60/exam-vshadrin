/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mysite.beans;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Stateless
public class AuthService {
   
    @Inject HttpSession session;
    
    public boolean isAuth() {
        Boolean auth = (Boolean) session.getAttribute("auth");
        return auth != null && auth;
    }
    
    public void setAuth(boolean isAuth) {
        session.setAttribute("auth", isAuth);
    } 
}
