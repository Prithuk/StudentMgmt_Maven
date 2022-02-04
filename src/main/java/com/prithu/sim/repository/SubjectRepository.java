///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.sim.repository;
//
//import com.prithu.sim.dto.Student;
//import com.prithu.sim.dto.Subject;
//import com.prithu.sim.util.DbUtil;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author lion
// */
//public class SubjectRepository {
//
//    PreparedStatement ps = null;
//
//    private List<Subject> subjectList = new ArrayList<>();
//
//    public List<Subject> getSubjectList() {
//        return subjectList;
//    }
//
//    public void setSubjectList(List<Subject> subjectList) {
//        this.subjectList = subjectList;
//    }
//
//    public SubjectRepository() {
//
//    }
//
//    public Long getSubmaxId() {
//        Long max = 10L;
//        String sql = "select max(id) from Subject";
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//
//                max = rs.getLong(1);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return max;
//
//    }
//
//}
