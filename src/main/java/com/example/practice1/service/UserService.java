package com.example.practice1.service;

import com.example.practice1.domain.User;
import com.example.practice1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("This username is already taken");
        }

        userRepository.save(user);
    }
}