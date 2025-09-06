package com.example.demo.web.dto.order;

import com.example.demo.enums.OrderStatus;

import java.math.BigDecimal;

public record OrderShortDto (
        Long id,
        OrderStatus status,
        BigDecimal price
){
}
