package com.example.controller;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/all")
    public List<UserDto> findAll() {
        return convertToListUserDtos(userService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable long id) {
        return convertToUserDto(userService.findById(id));
    }

    @Override
    @PostMapping
    public UserDto save(@RequestBody UserDto userDto) {
        return convertToUserDto(userService.save(convertToUser(userDto)));
    }

    @Override
    @PutMapping
    public UserDto modifyById(@RequestBody UserDto userDto) {
        return convertToUserDto(userService.modifyById(convertToUser(userDto)));
    }

    @Override
    @DeleteMapping("/{id}")
    public UserDto disableById(@PathVariable long id) {
        return convertToUserDto(userService.disableById(id));
    }

    private User convertToUser(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

    private UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getUserId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setAddress(user.getAddress());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }

    private List<UserDto> convertToListUserDtos(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users){
            userDtos.add(convertToUserDto(user));
        }
        return userDtos;
    }
}
