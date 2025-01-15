package com.codewithjay.rating.RatingMicroservice.controllers;

import com.codewithjay.rating.RatingMicroservice.entities.User;
import com.codewithjay.rating.RatingMicroservice.repository.UserRepository;
import com.codewithjay.rating.RatingMicroservice.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping
    public User getUser(@RequestParam  String userName){
        return userRepository.findByUserName(userName);

    }
    @GetMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }
}
