package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(long id);
    User save(User user);
    User modifyById(User user);
    User disableById(long id);
}
