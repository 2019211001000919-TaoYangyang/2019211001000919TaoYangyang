package com.TaoYangyang.week3.Dao.Impl;

import com.TaoYangyang.week3.Dao.UserDao;
import com.TaoYangyang.week3.Pojo.User;
import com.TaoYangyang.week3.Utils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAllUser() {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from usertable";
        Connection conn = jdbcUtil.getConnection();
        try {
            List<User> allUser = qr.query(conn, sql, new BeanListHandler<>(User.class));
            return allUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.colse(null,null,conn);
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        QueryRunner qr = new QueryRunner();
        String sql = "insert into usertable(username,password,email,gender,birth) values(?,?,?,?,?)";
        Connection conn = jdbcUtil.getConnection();
        try {
            return qr.update(conn,sql,new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getBirth()});
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.colse(null,null,conn);
        }
        return 0;
    }
}
