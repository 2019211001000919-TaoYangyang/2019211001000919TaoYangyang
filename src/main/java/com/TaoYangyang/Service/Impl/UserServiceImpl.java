//package com.TaoYangyang.Service.Impl;
//
//import com.TaoYangyang.Dao.Impl.UserDaoImpl;
//import com.TaoYangyang.Dao.UserDao;
//import com.TaoYangyang.Model.User;
//import com.TaoYangyang.Service.UserService;
//
//import java.util.List;
//
//public class UserServiceImpl implements UserService {
//
//    UserDao userDao = new UserDaoImpl();
//
//    @Override
//    public List<User> findAllUser() {
//        return userDao.findAllUser();
//    }
//
//    @Override
//    public int addUser(User user) {
//        return userDao.addUser(user);
//    }
//
//    @Override
//    public User findUser(String username, String password) {
//        return userDao.findUser(username,password);
//    }
//}
