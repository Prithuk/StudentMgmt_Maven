//package com.prithu.simw.controller;
//
//import com.prithu.sim.dto.Student;
//import com.prithu.sim.repository.StudentRepository;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//
///**
// *
// * @author lion
// */
//
//@ViewScoped
//@Named
//public class StudentControllerWeb implements Serializable {
//
//    private List<Student> studentList;
//    public Student student;
//
//    @Inject
//    private StudentRepository studentRepository;
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public List<Student> getStudentList() {
//        return studentList;
//    }
//
//    public void setStudentList(List<Student> studentList) {
//        this.studentList = studentList;
//    }
//
//    @PostConstruct
//    public void init() {
//        studentList = new ArrayList<>();
//        student = new Student();
//        loadStudentData();
//
//    }
//
//    public void loadStudentData() {
//        studentList = studentRepository.getAllStudentFromDB();
//    }
//
//}
