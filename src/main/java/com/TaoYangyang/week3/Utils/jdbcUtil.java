package com.TaoYangyang.week3.Utils;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;

public class jdbcUtil {

    private static String Sdriver;
    private static String Surl;
    private static String Susername;
    private static String Spassword;

    //获取连接
    public static Connection getConnection(String driver, String url, String username, String password){
        Sdriver = driver;
        Surl = url;
        Susername = username;
        Spassword = password;
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
            Class.forName(Sdriver); //注册驱动
            conn = DriverManager.getConnection(Surl, Susername, Spassword);
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
