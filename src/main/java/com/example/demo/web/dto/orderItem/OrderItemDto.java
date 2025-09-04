package com.example.demo.web.dto.orderItem;

import com.example.demo.web.dto.product.ProductDto;

import java.math.BigDecimal;

public record OrderItemDto(
        BigDecimal price,
        Integer quantity,
        ProductDto product
) {
}
