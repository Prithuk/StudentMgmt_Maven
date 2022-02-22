/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.Subject;
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
public class SubjectRepository extends AbstractRepository<Subject> {

    @PersistenceContext(unitName = "simDS")
    private EntityManager em;

    public SubjectRepository() {
        super(Subject.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Subject> getSubjectListFromDB() {
        List<Subject> subjectList = new ArrayList();
        try {
            Query query = em.createQuery("select sub from Subject sub", Subject.class);
            subjectList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return subjectList;
    }

}
