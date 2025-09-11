package com.example.demo.web.dto.user;

import com.example.demo.web.dto.order.OrderDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.util.List;

@Data
public class UserOrderDto {
    private Long id;

    private String name;

    private String email;

    private List<OrderDto> orders;
}
