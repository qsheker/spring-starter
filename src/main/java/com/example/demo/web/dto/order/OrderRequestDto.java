package com.example.demo.web.dto.order;

import com.example.demo.web.dto.orderItem.OrderItemRequestDto;

import java.util.List;

public record OrderRequestDto(
        List<OrderItemRequestDto> items
) {
}
