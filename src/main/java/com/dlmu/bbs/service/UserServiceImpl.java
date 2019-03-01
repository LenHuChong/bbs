package com.dlmu.bbs.service;

import com.dlmu.bbs.domain.User;
import com.dlmu.bbs.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updataUser(User user) {
            userRepository.save(user);
    }

    @Override
    public void addUser(User user) {
            userRepository.save(user);
    }

    @Override
    public void removeById(String id) {
            userRepository.deleteById(id);
    }
}
