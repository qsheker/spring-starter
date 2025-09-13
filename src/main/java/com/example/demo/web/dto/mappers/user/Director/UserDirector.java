package com.example.demo.web.dto.mappers.user.Director;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.user.UserTotalPriceDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserDirector {
    public UserTotalPriceDto createUserWithTotalPrice(BigDecimal totalPrice,User user){
        return UserTotalPriceDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .totalPrice(totalPrice)
                .build();
    }
}
