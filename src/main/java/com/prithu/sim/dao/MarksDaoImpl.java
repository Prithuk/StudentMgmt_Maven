///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.sim.dao;
//
//import com.prithu.sim.dto.Marks;
//import com.prithu.sim.util.DbUtil;
//import java.sql.PreparedStatement;
//
///**
// *
// * @author lion
// */
//public class MarksDaoImpl implements MarksDao {
//
//    PreparedStatement ps = null;
//
//    @Override
//    public void addMarks(Marks marks) {
//
//        String sql = "Insert into marks(student_id, subject_id, sub_marks) values (?,?,?)";
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//
//            ps.setLong(1, marks.getStudentId());
//            ps.setLong(2, marks.getSubjectId());
//            ps.setFloat(3, marks.getSubMarks());
//            ps.executeUpdate();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//}
