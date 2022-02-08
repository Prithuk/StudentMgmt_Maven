/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.repository;

import com.prithu.sim.dto.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StudentRepository {

    @PersistenceContext(unitName = "simDS")
    private EntityManager entityManager;

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

    public void addNewStudent(Student student) {

        this.entityManager.persist(student);
        entityManager.flush();
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void editStudent(Student student) {
        entityManager.merge(student);
        entityManager.flush();
    }

    public void deleteStudent(Student student) {
        getEntityManager().remove(getEntityManager().merge(student));
        getEntityManager().flush();
    }
}
