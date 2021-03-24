package com.TaoYangyang.week3.Service.Impl;

import com.TaoYangyang.week3.Dao.Impl.UserDaoImpl;
import com.TaoYangyang.week3.Dao.UserDao;
import com.TaoYangyang.week3.Pojo.User;
import com.TaoYangyang.week3.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAllUser() {
        UserDao userDao = new UserDaoImpl();
        return userDao.findAllUser();
    }

    @Override
    public int addUser(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.addUser(user);
    }
}
