package com.TaoYangyang.week3.Service;

import com.TaoYangyang.week3.Pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    int addUser(User user);
}
