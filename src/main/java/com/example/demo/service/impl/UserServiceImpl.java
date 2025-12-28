// // package com.example.demo.service.impl;

// // import com.example.demo.model.User;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.UserService;
// // import java.util.List;

// // public class UserServiceImpl implements UserService {
// //     private final UserRepository userRepository;

// //     public UserServiceImpl(UserRepository userRepository) {
// //         this.userRepository = userRepository;
// //     }

// //     @Override
// //     public User registerUser(User user) {
// //         if (userRepository.existsByEmail(user.getEmail())) {
// //             throw new RuntimeException("Email already exists");
// //         }
// //         return userRepository.save(user);
// //     }

// //     @Override
// //     public User getUser(Long id) {
// //         return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
// //     }

// //     @Override
// //     public List<User> getAllUsers() {
// //         return userRepository.findAll();
// //     }
// // }



// // // // package com.example.demo.service.impl;

// // // // import com.example.demo.model.User;
// // // // import com.example.demo.repository.UserRepository;
// // // // import com.example.demo.service.UserService;
// // // // import org.springframework.beans.factory.annotation.Autowired;
// // // // import org.springframework.stereotype.Service;
// // // // import java.util.List;

// // // // @Service
// // // // public class UserServiceImpl implements UserService {
    
// // // //     @Autowired
// // // //     private UserRepository userRepository;
    
// // // //     public UserServiceImpl() {}
    
// // // //     public UserServiceImpl(UserRepository userRepository) {
// // // //         this.userRepository = userRepository;
// // // //     }

// // // //     @Override
// // // //     public User registerUser(User user) {
// // // //         if (userRepository.existsByEmail(user.getEmail())) {
// // // //             throw new RuntimeException("Email already exists");
// // // //         }
// // // //         return userRepository.save(user);
// // // //     }

// // // //     @Override
// // // //     public User getUser(Long id) {
// // // //         return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
// // // //     }

// // // //     @Override
// // // //     public List<User> getAllUsers() {
// // // //         return userRepository.findAll();
// // // //     }
// // // // }




// // // package com.example.demo.service.impl;

// // // import com.example.demo.model.User;
// // // import com.example.demo.service.UserService;
// // // import org.springframework.stereotype.Service;

// // // import java.util.ArrayList;
// // // import java.util.List;

// // // @Service
// // // public class UserServiceImpl implements UserService {

// // //     private final List<User> users = new ArrayList<>();

// // //     @Override
// // //     public User registerUser(User user) {
// // //         users.add(user);
// // //         return user;
// // //     }

// // //     @Override
// // //     public User getUser(Long id) {
// // //         return users.stream()
// // //                 .filter(u -> id.equals(u.getId()))
// // //                 .findFirst()
// // //                 .orElse(null);
// // //     }

// // //     @Override
// // //     public List<User> getAllUsers() {
// // //         return users;
// // //     }
// // // }






// // // // package com.example.demo.service.impl;

// // // // import com.example.demo.model.User;
// // // // import com.example.demo.repository.UserRepository;
// // // // import com.example.demo.service.UserService;
// // // // import org.springframework.stereotype.Service;

// // // // import java.util.List;

// // // // @Service
// // // // public class UserServiceImpl implements UserService {

// // // //     private final UserRepository userRepository;

// // // //     public UserServiceImpl(UserRepository userRepository) {
// // // //         this.userRepository = userRepository;
// // // //     }

// // // //     @Override
// // // //     public User registerUser(User user) {
// // // //         return userRepository.save(user);
// // // //     }

// // // //     @Override
// // // //     public User getUser(Long id) {
// // // //         return userRepository.findById(id).orElse(null);
// // // //     }

// // // //     @Override
// // // //     public List<User> getAllUsers() {
// // // //         return userRepository.findAll();
// // // //     }
// // // // }



// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class UserServiceImpl implements UserService {
    
//     @Autowired
//     private UserRepository userRepository;
    
//     public UserServiceImpl() {}
    
//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public User registerUser(User user) {
//         if (userRepository.existsByEmail(user.getEmail())) {
//             throw new RuntimeException("Email already exists");
//         }
//         return userRepository.save(user);
//     }

//     @Override
//     public User getUser(Long id) {
//         return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public UserServiceImpl() {}
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}