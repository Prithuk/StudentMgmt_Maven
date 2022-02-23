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
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author lion
 */
@Singleton
@Startup
public class AdminActController implements Serializable {

    @Inject
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = userRepository.findByUserName("admin");
        if (user == null) {
            user = new User();
            String username = "admin";
            String password = "admin";
            user.setName(username);
            user.setPassword(SHA1Encrypter.getEncrypted(password));
            userRepository.addNew(user);
        }
    }
}
