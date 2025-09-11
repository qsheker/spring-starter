package com.example.demo.web.dto.orderItem;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price;
}
