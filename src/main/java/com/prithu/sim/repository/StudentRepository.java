/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.Grade;
import com.prithu.sim.dto.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.model.LazyDataModel;

@Stateless
public class StudentRepository extends AbstractUserTrackerRepository<Student> {

    @PersistenceContext(unitName = "simDS")
    private EntityManager entityManager;

    public StudentRepository() {
        super(Student.class);
    }
    private LazyDataModel<Student> dataModel;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Student> getAllStudentFromDB() {
        List<Student> studentList = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("select s from Student s", Student.class);
            studentList = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return studentList;
    }

    public List<Student> searchStudentByGrade(Grade grade) {
        List<Student> studentList = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("select s from Student s where s.grade=:studentclass", Student.class);
            query.setParameter("studentclass", grade);
            studentList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public List<Student> lazyload(int offset, int pageSize) {
        List<Student> students = new ArrayList<>();
        Query query = entityManager.createQuery("select s from Student s ", Student.class);
        students = query.setMaxResults(pageSize).setFirstResult(offset).getResultList();
        return students;
    }

    public int count() {
        Query query = entityManager.createQuery("select count(s) from Student s", Long.class);
        Long c = (Long) query.getSingleResult();
        return c == null ? 0 : c.intValue();
    }

}
