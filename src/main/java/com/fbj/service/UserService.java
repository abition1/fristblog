package com.fbj.service;

import com.fbj.pojo.User;


public interface UserService {
    User findByUsername(String username);

    User findAllUser();
}
