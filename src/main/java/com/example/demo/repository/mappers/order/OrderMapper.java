package com.example.demo.repository.mappers.order;



import com.example.demo.domain.entity.Order;
import com.example.demo.web.dto.order.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper{
    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);
}
