package com.example.demo.web.dto.user;

import com.example.demo.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private Role role;
}
