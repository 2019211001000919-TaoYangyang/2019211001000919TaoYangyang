package com.TaoYangyang.week3.Service.Impl;

import com.TaoYangyang.week3.Dao.Impl.UserDaoImpl;
import com.TaoYangyang.week3.Dao.UserDao;
import com.TaoYangyang.week3.Pojo.User;
import com.TaoYangyang.week3.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User findUser(String username, String password) {
        return userDao.findUser(username,password);
    }
}
