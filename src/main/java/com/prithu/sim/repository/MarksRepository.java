/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.Marks;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lion
 */
@Stateless
public class MarksRepository {

    @PersistenceContext(unitName = "simDS")
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Marks> getAllMarksFromDB() {

        List<Marks> marksList = new ArrayList<>();

        try {
            Query query = entityManager.createQuery("select m from Marks m", Marks.class);
            marksList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return marksList;

    }

    public void addNewMarks(Marks marks) {

        this.entityManager.persist(marks);
        entityManager.flush();
    }

    public Marks findById(Long id) {
        return entityManager.find(Marks.class, id);
    }

    public void editMarks(Marks marks) {
        entityManager.merge(marks);
        entityManager.flush();
    }

    public void deleteMarks(Marks marks) {
        getEntityManager().remove(getEntityManager().merge(marks));
        getEntityManager().flush();
    }

}
