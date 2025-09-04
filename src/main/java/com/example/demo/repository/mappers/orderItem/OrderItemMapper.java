package com.example.demo.repository.mappers.orderItem;


import com.example.demo.domain.entity.OrderItem;
import com.example.demo.web.dto.orderItem.OrderItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto toDto(OrderItem orderItem);

    OrderItem toEntity(OrderItemDto orderItemDto);
}
