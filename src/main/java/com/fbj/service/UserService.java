package com.fbj.service;

import com.fbj.pojo.User;

public interface UserService {
    User findByUsernameAndPassword(String username, String password);
}
