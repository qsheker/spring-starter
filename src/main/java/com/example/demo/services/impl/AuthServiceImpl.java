package com.example.demo.services.impl;

import com.example.demo.services.AuthService;
import com.example.demo.web.dto.auth.JwtRequest;
import com.example.demo.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest jwtRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
