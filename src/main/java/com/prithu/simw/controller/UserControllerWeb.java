/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.simw.controller;

import com.prithu.sim.dto.User;
import com.prithu.sim.repository.UserRepository;
import com.prithu.sim.security.SHA1Encrypter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class UserControllerWeb implements Serializable {

    private List<User> userList;
    private User user;

    @Inject
    private UserRepository userRepository;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PostConstruct
    public void init() {
        userList = new ArrayList<>();
        user = new User();
        loadData();

    }

    public void loadData() {
        userList = userRepository.getUserListFromDB();
    }

    public void beforeCreate() {
        user = new User();
        System.out.println(user);
    }

    public void addUser() {
        String enc = SHA1Encrypter.getEncrypted(user.getPassword());
        user.setPassword(enc);
        userRepository.addNew(user);
        this.user = new User();
        loadData();
    }

    public void beforeEdit(Long id) {
        user = userRepository.findById(id);
        System.out.println(user);
    }

    public void editUser() {
        userRepository.edit(user);
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("User is updated successfully"));
        loadData();
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
        loadData();
    }

    public String validateUser() {
        if (!user.getName().isEmpty()) {
            User usr = userRepository.findByUserName(user.getName());
            if (usr == null) {
                System.out.println("Check1");
                return "loginpage.xhtml";
            }
            if (usr.getPassword().equals(user.getPassword())) {
                System.out.println("Check2");
                return "index.xhtml";
            }
        }
        System.out.println("Main Check");
        return "loginpage.xhtml";
    }

    public void searchUser() {
        if (!user.getName().isEmpty()) {
            User userList1 = userRepository.findByUserName(user.getName());

            if (userList1 == null) {
                System.out.println("User not found");
            } else {
                System.out.println("User is found");
                System.out.println(userList1.toString());
            }
        }
    }

}
