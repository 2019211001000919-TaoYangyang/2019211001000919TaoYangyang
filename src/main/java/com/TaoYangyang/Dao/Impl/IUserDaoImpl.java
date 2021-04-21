package com.TaoYangyang.Dao.Impl;

import com.TaoYangyang.Dao.IUserDao;
import com.TaoYangyang.Model.User;
import com.TaoYangyang.Utils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class IUserDaoImpl implements IUserDao {

    QueryRunner qr = new QueryRunner();

    @Override
    public int saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable(username,password,email,gender,birth) values(?,?,?,?,?)";
        return qr.update(con,sql,new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getBirth()});
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from usertable where id = ?";
        return qr.update(con,sql,new Object[]{user.getId()});
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {

        String sql = "update usertable set username = ?,password = ?, email = ?, gender = ?, birth = ? where id = ?";
        return qr.update(con,sql,new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getBirth(),user.getId()});
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {

        String sql = "select * from usertable where id =  " + id;
        return qr.query(con, sql ,new BeanHandler<>(User.class));
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select * from usertable where username = '" + username + "' and password = '" + password + "'";
        return qr.query(con, sql ,new BeanHandler<>(User.class));
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from usertable where username = " + username;
        return qr.query(con, sql, new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from usertable where password = " + password;
        return qr.query(con, sql, new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from usertable where email = " + email;
        return  qr.query(con, sql, new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from usertable where gender = " + gender;
        return  qr.query(con, sql, new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select * from usertable where birth = " + birthDate;
        return  qr.query(con, sql, new BeanListHandler<>(User.class));
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from usertable";
        return  qr.query(con, sql, new BeanListHandler<>(User.class));
    }
}
