package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findById(String id);
    void updataUser(User user);
    void addUser(User user);
    void removeById(String id);

}
