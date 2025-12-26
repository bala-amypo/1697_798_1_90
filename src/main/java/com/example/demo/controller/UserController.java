package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User registerUser(User user) {
        return userService.registerUser(user);
    }

    public User getUser(Long id) {
        return userService.getUser(id);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}