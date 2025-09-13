package com.example.demo.repository.mappers.user.Director;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.user.UserTotalPriceDto;

import java.math.BigDecimal;

public class UserDirector {
    public UserTotalPriceDto createUserWithTotalPrice(BigDecimal totalPrice,User user){
        return new UserTotalPriceDto().builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .totalPrice(totalPrice)
                .build();
    }
}
