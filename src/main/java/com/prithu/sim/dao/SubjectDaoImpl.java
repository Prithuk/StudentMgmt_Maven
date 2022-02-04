///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.sim.dao;
//
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
//public class SubjectDaoImpl implements SubjectDao {
//
//    PreparedStatement ps = null;
//
//    @Override
//    public void addSubject(Subject subject) {
//        String sql = "Insert into Subject(id, name) values(?,?) ";
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//            ps.setLong(1, subject.getId());
//            ps.setString(2, subject.getSubName());
//            ps.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public List<Subject> viewSubject() {
//        String sql = "select * from Subject";
//        List<Subject> subjectList = new ArrayList<>();
//
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Subject subject = new Subject();
//                subject.setId(rs.getLong(1));
//                subject.setSubName(rs.getString(2));
//                subjectList.add(subject);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return subjectList;
//
//    }
//
//}
