// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public User registerUser(User user) {
//         if (userRepository.existsByEmail(user.getEmail())) {
//             throw new RuntimeException("email already exists");
//         }
//         if (user.getPassword().length() < 8) {
//             throw new RuntimeException("password too short");
//         }
//         return userRepository.save(user);
//     }

//     @Override
//     public User getUser(Long id) {
//         return userRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("user not found"));
//     }

//     @Override
//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User createUser(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    // }

    @Override
    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = getUserById(id);
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setRole(user.getRole());
        return repo.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
