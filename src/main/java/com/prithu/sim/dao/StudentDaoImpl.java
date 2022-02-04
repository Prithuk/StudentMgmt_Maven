///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.sim.dao;
//
//import com.prithu.sim.dto.Student;
//import com.prithu.sim.util.DbUtil;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author lion
// */
//public class StudentDaoImpl implements StudentDao {
//    
//    PreparedStatement preparedStatement = null;
//    
//    @Override
//    public void saveStudentInfo(Student student) {
//        String sql = "Insert into student_info(student_id,student_name,student_class,student_email,student_phone) values(?,?,?,?,?)";
//        try {
//            preparedStatement = DbUtil.getConnection().prepareStatement(sql);
//            preparedStatement.setLong(1, student.getsID());
//            preparedStatement.setString(2, student.getsName());
//            preparedStatement.setInt(3, student.getsClass());
//            preparedStatement.setString(4, student.getsEmail());
//            preparedStatement.setLong(5, student.getsPhone());
//            preparedStatement.executeUpdate();
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        
//    }
//    
//    @Override
//    public void viewStudentClass() {
//        
//       
//    }
//    
//    @Override
//    public List<Student> getAllStudentInfo() {
//        
//        String sql = "select student_id, student_name, student_class, student_email, student_phone from student_info";
//        List<Student> studentList = new ArrayList<>();
//        
//        try {
//            preparedStatement = DbUtil.getConnection().prepareStatement(sql);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                Student student = new Student();
//                student.setsID(rs.getLong(1));
//                student.setsName(rs.getString(2));
//                student.setsClass(rs.getInt(3));
//                student.setsEmail(rs.getString(4));
//                student.setsPhone(rs.getLong(5));
//                studentList.add(student);
//            }
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        
//        return studentList;
//    }
//    
//}
