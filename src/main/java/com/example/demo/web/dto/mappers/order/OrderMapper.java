package com.example.demo.repository.mappers.order;



import com.example.demo.domain.entity.Order;
import com.example.demo.repository.mappers.orderItem.OrderItemMapper;
import com.example.demo.web.dto.order.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderItemMapper.class})
public interface OrderMapper{
    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);
}
