/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.filter.SessionUtils;
import javax.inject.Inject;

public abstract class AbstractUserTrackerRepository<T extends IUserTracker> extends AbstractRepository<T> {

    @Inject
    SessionUtils sessionUtils;

    public AbstractUserTrackerRepository(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public void addNew(T a) {
        a.setCreatedBy(sessionUtils.getUser());
        super.addNew(a);
    }

    @Override
    public void edit(T a) {
        a.setUpdatedBy(sessionUtils.getUser());
        super.edit(a);
    }

}
