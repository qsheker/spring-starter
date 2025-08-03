package com.example.demo.services;

import com.example.demo.annotations.Inject;
import com.example.demo.repositories.UserRepository;

public class UserService {
    @Inject
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
