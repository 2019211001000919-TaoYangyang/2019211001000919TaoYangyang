package com.TaoYangyang.week3.Utils;

import java.sql.*;

public class jdbcUtil {

    //获取连接
    public static Connection getConnection(String driver, String url, String username, String password){
        Connection conn= null;
        try {
            Class.forName(driver); //注册驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //获取连接
    public static Connection getConnection(){
        Connection conn= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //注册驱动
            String url = "jdbc:mysql://localhost:3306/productdb";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //释放资源
    public static void colse(ResultSet rs, Statement stmt, Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
