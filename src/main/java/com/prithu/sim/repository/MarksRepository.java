///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.sim.repository;
//
//import com.prithu.sim.controller.MarksController;
//import com.prithu.sim.dto.Marks;
//import com.prithu.sim.dto.Student;
//import com.prithu.sim.util.DbUtil;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// *
// * @author lion
// */
//public class MarksRepository {
//
//    PreparedStatement ps = null;
//
//    public List<Marks> getMarkList() {
//        List<Marks> markList = new ArrayList<>();
//        String sql = "select * from marks";
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Marks marks = new Marks();
//                marks.setStudentId(rs.getLong(1));
//                marks.setSubjectId(rs.getLong(2));
//                marks.setSubMarks(rs.getLong(3));
//                markList.add(marks);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return markList;
//    }
//
//    public List<Marks> getMarkListByStudent(Student student) {
//        List<Marks> markList = new ArrayList<>();
//        String sql = "select * from marks where student_id = ?";
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//            ps.setLong(1, student.getsID());
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Marks marks = new Marks();
//                marks.setStudentId(rs.getLong(1));
//                marks.setSubjectId(rs.getLong(2));
//                marks.setSubMarks(rs.getLong(3));
//                markList.add(marks);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return markList;
//    }
//
//    static MarksController marksController = new MarksController();
//
//    SubjectRepository subjectRepository;
//    List<MarksRepository> marksRepositorys = new ArrayList<>();
//
//    public MarksRepository() {
//        subjectRepository = new SubjectRepository();
//
//    }
//
//    public SubjectRepository getSubjectRepository() {
//        return subjectRepository;
//    }
//
//    public void setSubjectRepository(SubjectRepository subjectRepository) {
//        this.subjectRepository = subjectRepository;
//    }
//
//    public void displayInfo(Student student) {
//        System.out.println("Result of" + student.getsName() + "is");
//        System.out.println("Subject" + "\t" + "Marks");
//        List<Marks> markList = getMarkListByStudent(student);
//
//        for (Marks marks : markList) {
//            System.out.println(marks.getSubjectId() + "\t" + marks.getSubMarks());
//        }
//        System.out.println("total marks :" + getTotalMarks(markList));
//
//        List<Long> subList = getStudentSubjectsMap(markList).getOrDefault(student.getsID(), new ArrayList<Long>());
//        float totalSubject = subList.size();
//        float percent = getPercentage(markList, totalSubject);
//        System.out.println("Percentage is :" + percent);
//        System.out.println("Divison is :" + getDivison(percent));
//    }
//
//    public String getDivison(float percent) {
//
//        if (percent >= 80 && percent < 100) {
//            return "--- Distinction ---";
//        } else if (percent >= 60 && percent < 80) {
//            return "--- First Divison ---";
//        } else if (percent >= 45 && percent < 60) {
//            return "Second Divison";
//        } else if (percent >= 40 && percent < 45) {
//            return "Third Divison";
//        } else {
//            return "Failed";
//        }
//    }
//
//    public float getTotalMarks(List<Marks> markList) {
//        float total = 0;
//        for (Marks marks : markList) {
//            total = total + marks.getSubMarks();
//        }
//        return total;
//    }
//
//    public List<Long> getUnqSubjectsForStd(Student student, List<Marks> marksList) {
//        List<Long> subjectList = new ArrayList<>();
//        for (Marks m : marksList) {
//            if (m.getStudentId().equals(student.getsID()) && !subjectList.contains(m.getSubjectId())) {
//                subjectList.add(m.getSubjectId());
//            }
//        }
//        return subjectList;
//    }
//
//    public List<Long> getUnqStudents(List<Marks> marksList) {
//        List<Long> stds = new ArrayList<>();
//        for (Marks m : marksList) {
//            if (!stds.contains(m.getStudentId())) {
//                stds.add(m.getStudentId());
//            }
//        }
//        return stds;
//    }
//
//    public Map<Long, List<Long>> getStudentSubjectsMap(List<Marks> marks) {
//        Map<Long, List<Long>> studentSubMap = new HashMap<>();
//        List<Long> students = getUnqStudents(marks);
//        for (Long std : students) {
//            Student student = new Student();
//            student.setsID(std);
//            studentSubMap.put(std, getUnqSubjectsForStd(student, marks));
//        }
//        return studentSubMap;
//    }
//
//    public float getPercentage(List<Marks> markList, float totalSubject) {
//        float totalMarks = getTotalMarks(markList);
//        float percentage = (totalMarks / (totalSubject * 100)) * 100;
//        return percentage;
//    }
//}
