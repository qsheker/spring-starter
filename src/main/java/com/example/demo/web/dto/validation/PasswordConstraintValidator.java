package com.example.demo.web.dto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword,String> {
    private static final String PASSWORD_PATTERN =
            "^(?=.{8,}$)(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).*$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;
        if (password.contains(" ")) return false; // опция
        return password.matches(PASSWORD_PATTERN);
    }
}