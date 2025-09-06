package com.example.demo.repository.mappers.order;

import com.example.demo.domain.entity.Order;
import com.example.demo.web.dto.order.OrderShortDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderShortMapper {
    OrderShortDto toDto(Order order);

    Order toEntity(OrderShortDto orderDto);
}
