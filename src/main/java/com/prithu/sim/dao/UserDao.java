/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.dao;

import com.prithu.sim.dto.User;
import java.util.List;

/**
 *
 * @author lion
 */
public interface UserDao {

    public void saveUserInfo(User user);

    public User searchUser(String username);

    public List<User> getAllUserInfo();


}
