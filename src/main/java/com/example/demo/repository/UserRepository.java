package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    boolean existsByEmail(String email);
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> findByEmail(String email);
}