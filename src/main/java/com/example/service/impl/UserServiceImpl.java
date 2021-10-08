package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        user.setEnable(true);
        return userRepository.save(user);
    }

    @Override
    public User modifyById(User user) {
        Optional<User> optionUser = userRepository.findById(user.getUserId());
        if (!optionUser.isPresent())
            return null;
        User newUser = setNewUser(user, optionUser.get());
        return userRepository.save(newUser);
    }

    @Override
    public User disableById(long id) {
        Optional<User> optionUser = userRepository.findById(id);
        if (!optionUser.isPresent())
            return null;
        optionUser.get().setEnable(false);
        return userRepository.save(optionUser.get());
    }

    private User setNewUser(User user, User existedUser){
        User newUser = new User();
        newUser.setUserId(existedUser.getUserId());
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setAddress(user.getAddress());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setEnable(existedUser.getEnable());
        return newUser;
    }
}
