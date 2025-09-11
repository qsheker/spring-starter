package com.example.demo.web.dto.orderItem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemRequestDto {
    @NotNull(message = "Product id can not be null!")
    private Long productId;

    @Positive
    @Min(1)
    private Integer quantity;
}
