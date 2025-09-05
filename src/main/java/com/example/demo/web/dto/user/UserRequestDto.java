package com.example.demo.web.dto.user;

import com.example.demo.enums.Role;

public record UserRequestDto(
        Long id,
        String name,
        String email,
        String password,
        Role role
) {
}
