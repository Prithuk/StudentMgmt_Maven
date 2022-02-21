/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.Grade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GradeRepository {

    @PersistenceContext(unitName = "simDS")
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Grade> getAllGradeFromDB() {
        List<Grade> gradeList = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("select g from Grade g", Grade.class);
            gradeList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return gradeList;
    }

    public void addNewGrade(Grade grade) {
        this.entityManager.persist(grade);
        entityManager.flush();
    }

    public Grade findById(Long id) {
        return entityManager.find(Grade.class, id);
    }

    public void editGrade(Grade grade) {
        entityManager.merge(grade);
        entityManager.flush();
    }

    public void deleteGrade(Grade grade) {
        getEntityManager().remove(getEntityManager().merge(grade));
        getEntityManager().flush();
    }

    public List<Grade> searchGradeByName(String name) {
        List<Grade> gradeList = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("select g from Grade g where g.name=:gradeclass", Grade.class);
            query.setParameter("gradeclass", name);
            gradeList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradeList;
    }

}
