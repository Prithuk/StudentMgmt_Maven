///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.sim.dao;
//
//import com.prithu.sim.dto.User;
//import com.prithu.sim.util.DbUtil;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author lion
// */
//public class UserDaoImpl implements UserDao {
//
//    PreparedStatement ps = null;
//
//    @Override
//    public void saveUserInfo(User user) {
//
//        String sql = "Insert into user_info(id,name,password)values(?,?,?)";
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//            ps.setLong(1, user.getId());
//            ps.setString(2, user.getName());
//            ps.setString(3, user.getPassword());
//            ps.executeUpdate();
//
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<User> getAllUserInfo() {
//
//        String sql = "Select * from user_info";
//        List<User> userList = new ArrayList<>();
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                User user = new User();
//                user.setId(rs.getLong(1));
//                user.setName(rs.getString(2));
//                user.setPassword(rs.getString(3));
//                userList.add(user);
//            }
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return userList;
//    }
//
//    @Override
//    public User searchUser(String username) {
//
//        String sql = "Select id ,name, password from user_info where name = ? ";
//        User user = null;
//        try {
//            ps = DbUtil.getConnection().prepareStatement(sql);
//            ps.setString(1, username);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                user = new User();
//                user.setId(rs.getLong(1));
//                user.setName(rs.getString(2));
//                user.setPassword(rs.getString(3));
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return user;
//    }
//
//}
