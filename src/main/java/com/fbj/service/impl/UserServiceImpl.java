package com.fbj.service.impl;

import com.fbj.dao.UserDao;
import com.fbj.pojo.User;
import com.fbj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import until.MD5Utils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;



    @Override
    public User findByUsername(String username) {

        return userDao.findByUsername(username);
    }

    @Override
    public User findAllUser() {
        return userDao.findAllUser();
    }
}
