package com.techfix.techfixuserservice.controller;

import com.techfix.techfixuserservice.model.UserEntity;
import com.techfix.techfixuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity userRequest) {
        UserEntity createdUser = userService.registerUser(userRequest);
        return ResponseEntity.ok("User registered with ID: " + createdUser.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity userRequest) {
        boolean loggedIn = userService.loginUser(userRequest.getUsername(), userRequest.getPassword());
        if (loggedIn) {
            return ResponseEntity.ok("User logged in successfully.");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }
}