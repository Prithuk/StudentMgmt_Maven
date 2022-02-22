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
public class GradeRepository extends AbstractRepository<Grade> {

    @PersistenceContext(unitName = "simDS")
    private EntityManager entityManager;

    public GradeRepository() {
        super(Grade.class);
    }

    @Override
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
