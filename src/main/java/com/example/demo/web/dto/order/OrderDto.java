package com.example.demo.web.dto.order;

import com.example.demo.enums.OrderStatus;
import com.example.demo.web.dto.orderItem.OrderItemDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private List<OrderItemDto> items;
}
