package com.example.demo.web.dto.order;

import com.example.demo.web.dto.orderItem.OrderItemRequestDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {

    @NotNull(message = "User id can not be null!")
    private Long userId;

    private List<OrderItemRequestDto> items;
}
