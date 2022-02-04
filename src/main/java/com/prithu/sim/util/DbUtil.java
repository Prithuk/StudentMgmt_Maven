///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.prithu.sim.util;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// *
// * @author lion
// */
//public class DbUtil {
//
//    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/";
//    private static final String DB_NAME = "StudentInfoManagement";
//    private static final String USER_NAME = "Lion";
//    private static final String PASSWORD = "P@ssword1";
//
//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//
//        Class.forName(DRIVER_NAME);
//     //   return null;
//        return DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);
//
//    }
//
//}
