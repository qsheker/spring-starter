package com.example.demo.repository.mappers.order;

import com.example.demo.domain.entity.Order;
import com.example.demo.web.dto.order.OrderRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderRequestMapper {
    OrderRequestDto toDto(Order order);

    Order toEntity(OrderRequestDto orderDto);
}
