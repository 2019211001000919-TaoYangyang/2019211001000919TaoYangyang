package com.TaoYangyang.week3.Dao;

import com.TaoYangyang.week3.Pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUser();

    int addUser(User user);
}