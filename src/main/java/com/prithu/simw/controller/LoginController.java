/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.simw.controller;

import com.prithu.sim.dto.Login;
import com.prithu.sim.dto.User;
import com.prithu.sim.repository.UserRepository;
import com.prithu.sim.filter.SessionUtils;
import com.prithu.sim.security.SHA1Encrypter;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@ViewScoped
public class LoginController implements Serializable {

    @Inject
    private UserRepository userRepository;

    @Inject
    SessionUtils sessionUtils;

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @PostConstruct
    public void init() {
        login = new Login();
    }

    public String loginControl() {
        User user = userRepository.loginControlValidate(login.getUsername());
        if (user != null) {
            if (SHA1Encrypter.isEqual(login.getPassword(), user.getPassword())) {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                        .getSession(false);
                putUser(user, session);
                sessionUtils.setUser(user);
                return "index.xhtml";
            }
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("loginpage", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Incorrect Username and Password", "Username or password incorrect"));
        return null;

    }

    public String logout() {
        User u = sessionUtils.getUser();
        if (u == null) {
            return "loginpage.xhtml?faces-redirect=true";
        }
        Map<String, Object> appMap = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
        HttpSession session = (HttpSession) appMap.get(String.valueOf(u.getId()));
        if (session != null) {
            try {
                session.invalidate();
                LOG.info("killing session of user=" + u.getName() + " " + u.getPassword());
            } catch (IllegalStateException ise) {
                LOG.info("Session was already invalidated");
            }
        }
        appMap.remove(String.valueOf(u.getId()));
        return "loginpage.xhtml?faces-redirect=true";
    }

    private void putUser(User user, HttpSession session) {
        Map<String, Object> appMap = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
        appMap.put(user.getId().toString(), session);
    }

}
