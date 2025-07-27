package com.example.demo.services;

import com.example.demo.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public static UserService of(UserRepository userRepository){
        return new UserService(userRepository);
    }
}
