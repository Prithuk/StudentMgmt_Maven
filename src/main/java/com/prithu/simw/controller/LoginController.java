/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.simw.controller;

import com.prithu.sim.dto.Login;
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

    private final UserRepository userRepository = new UserRepository();
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    

    public void loginControl() {

        if (userRepository.loginControl(login.getUsername(), login.getPassword())) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", login.getUsername());
            doRedirect("index.xhtml");
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Incorrect Username and Passowrd", "Username or password incorrect"));
        doRedirect("logipage.xhtml");
    }

    // logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "loginpage.xhtml";
    }

    private void doRedirect(String url) {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect(url);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
