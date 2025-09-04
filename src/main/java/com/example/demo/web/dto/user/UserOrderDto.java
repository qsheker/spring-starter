package com.example.demo.web.dto.user;

import com.example.demo.web.dto.order.OrderDto;

import java.util.List;

public record UserOrderDto(
        Long id,
        String name,
        String email,
        List<OrderDto> orders
) {
}
