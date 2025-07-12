package com.example.practice1.controller;


import com.example.practice1.dto.LoginRequest;
import com.example.practice1.dto.RegisterRequest;
import com.example.practice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest) {
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {

    }
}
