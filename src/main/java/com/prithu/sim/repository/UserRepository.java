/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.User;
import java.util.ArrayList;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserRepository extends AbstractRepository<User> {

    @PersistenceContext(unitName = "simDS")
    private EntityManager em;

    public UserRepository() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<User> getUserListFromDB() {
        List<User> userList = new ArrayList();
        try {
            Query query = em.createQuery("select u from User u", User.class);
            userList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    public User findByUserName(String name) {
        User user = null;
        try {
            Query query = em.createQuery("select u from User u where u.name=:username", User.class);
            query.setParameter("username", name);
            user = (User) query.getSingleResult();
        } catch (Exception ex) {
            user = null;
        }
        return user;

    }

    public User loginControlValidate(String name) {
        User user = null;
        try {
            Query query = em.createQuery("select us from User us where us.name=:username ", User.class)
                    .setParameter("username", name);

            user = (User) query.getSingleResult();

        } catch (Exception e) {
            user = null;
            e.printStackTrace();
        }
        return user;
    }
}
