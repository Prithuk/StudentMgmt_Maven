/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;

public abstract class AbstractRepository<T> implements Serializable {

    private Class<T> entityClass;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void addNew(T a) {
        this.getEntityManager().persist(a);
        getEntityManager().flush();
    }

    public T findById(Object b) {
        return getEntityManager().find(entityClass, b);
    }

    public void edit(T a) {
        getEntityManager().merge(a);
        getEntityManager().flush();
    }

    public void delete(T a) {

        getEntityManager().remove(getEntityManager().merge(a));
        getEntityManager().flush();

    }

}
