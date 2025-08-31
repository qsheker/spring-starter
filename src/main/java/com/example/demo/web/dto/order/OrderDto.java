package com.example.demo.web.dto.order;

import com.example.demo.enums.OrderStatus;
import com.example.demo.web.dto.orderItem.OrderItemDto;
import com.example.demo.web.dto.user.UserShortDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
        Long id,
        LocalDateTime orderDate,
        OrderStatus orderStatus,
        BigDecimal totalPrice,
        UserShortDto user,
        List<OrderItemDto> items
){
}
