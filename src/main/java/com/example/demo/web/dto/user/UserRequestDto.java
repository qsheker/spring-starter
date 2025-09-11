package com.example.demo.web.dto.user;

import com.example.demo.enums.Role;
import com.example.demo.web.dto.validation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank(message = "Name cannot be blank!")
    private String name;

    @Email(message = "Must be a valid email!")
    private String email;

    @ValidPassword(message = "Password length must be more or equal than 8, upper 1, digit 1, special 1 symbol!")
    private String password;

    @NotNull(message = "Role must not be null!")
    private Role role;
}
