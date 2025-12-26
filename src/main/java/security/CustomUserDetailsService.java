package com.example.demo.security;

import com.example.demo.model.User;

public class CustomUserDetailsService {
    public User loadUserByUsername(String username) {
        return new User(username, username + "@test.com", "password", "USER");
    }
}