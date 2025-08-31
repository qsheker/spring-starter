package com.example.demo.web.dto.product;

import com.example.demo.web.dto.category.CategoryDto;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        CategoryDto category
) {
}
