package com.spring.api.controllers;

import com.spring.api.models.User;
import com.spring.api.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}
