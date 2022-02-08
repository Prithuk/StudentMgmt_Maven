package com.prithu.simw.controller;

import com.prithu.sim.dto.Student;
import com.prithu.sim.repository.StudentRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lion
 */
@ViewScoped
@Named
public class StudentControllerWeb implements Serializable {

    private List<Student> studentList;
    private Student student;

    @Inject
    private StudentRepository studentRepository;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

   

    @PostConstruct
    public void init() {
        studentList = new ArrayList<>();
        student = new Student();
        loadStudentData();

    }

    public void loadStudentData() {
        studentList = studentRepository.getAllStudentFromDB();
    }

    public void beforeCreate() {
        student = new Student();
        System.out.println(student);
    }

    public void addStudent() {
        studentRepository.addNewStudent(student);
        this.student = new Student();
        loadStudentData();
    }

    public void beforeEdit(Long id) {
        student = studentRepository.findById(id);
        System.out.println(student);
    }

    public void editStudent() {
        studentRepository.editStudent(student);
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Student is updated successfully"));
        loadStudentData();
    }

    public void deleteStudent(Student student) {
        studentRepository.deleteStudent(student);
        loadStudentData();
    }

}
