/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.User;

/**
 *
 * @author lion
 * @param <T>
 */
public interface IUserTracker {

    public User getCreatedBy();

    public void setCreatedBy(User createdBy);

    public User getUpdatedBy();

    public void setUpdatedBy(User updatedBy);
}
