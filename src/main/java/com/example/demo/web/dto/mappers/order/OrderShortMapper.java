package com.example.demo.repository.mappers.order;

import com.example.demo.domain.entity.Order;
import com.example.demo.web.dto.order.OrderShortDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderShortMapper {
    OrderShortDto toDto(Order order);

    Order toEntity(OrderShortDto orderDto);
}
