/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.simw.controller;

import com.prithu.sim.repository.UserRepository;
import com.prithu.sim.filter.SessionUtils;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lion
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private final UserRepository userRepository = new UserRepository();

    public String loginControl() {

        if (userRepository.loginControl(username, password)) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", username);
            return "index.xhtml";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Incorrect Username and Passowrd", "Username or password incorrect"));
        return "loginpage.xhtml";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "loginpage.xhtml";
    }
}
