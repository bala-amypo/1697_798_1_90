// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import java.util.List;

// public class UserController {
//     private final UserService userService;

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     public User registerUser(User user) {
//         return userService.registerUser(user);
//     }

//     public User getUser(Long id) {
//         return userService.getUser(id);
//     }

//     public List<User> getAllUsers() {
//         return userService.getAllUsers();
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try {
            User user = userService.getUser(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}