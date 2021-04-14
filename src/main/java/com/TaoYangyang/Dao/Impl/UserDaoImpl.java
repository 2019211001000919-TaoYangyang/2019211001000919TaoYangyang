//package com.TaoYangyang.Dao.Impl;
//
//import com.TaoYangyang.Dao.UserDao;
//import com.TaoYangyang.Model.User;
//import com.TaoYangyang.Utils.jdbcUtil;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//public class UserDaoImpl implements UserDao {
//    Connection conn = jdbcUtil.getConnection();
//    QueryRunner qr = new QueryRunner();
//
//    @Override
//    public List<User> findAllUser() {
//        String sql = "select * from usertable";
//        try {
//            List<User> allUser = qr.query(conn, sql, new BeanListHandler<>(User.class));
//            return allUser;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            jdbcUtil.colse(null,null,conn);
//        }
//        return null;
//    }
//
//    @Override
//    public int addUser(User user) {
//        String sql = "insert into usertable(username,password,email,gender,birth) values(?,?,?,?,?)";
//        try {
//            return qr.update(conn,sql,new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getBirth()});
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            jdbcUtil.colse(null,null,conn);
//        }
//        return 0;
//    }
//
//    @Override
//    public User findUser(String username, String password) {
//        String sql = "select * from usertable where username = '" + username + "' and password = '" + password + "'";
//        try {
//            User user = qr.query(conn, sql ,new BeanHandler<>(User.class));
//            return user;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            jdbcUtil.colse(null,null,conn);
//        }
//        return null;
//    }
//}
