package com.example.demo.web.dto.order;

import com.example.demo.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderShortDto {
    private Long id;
    private OrderStatus status;
    private BigDecimal price;
}
