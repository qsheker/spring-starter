package com.example.demo.web.dto.user;

import com.example.demo.enums.Role;



public record UserDto(
        Long id,
        String name,
        String email,
        Role role
){}
