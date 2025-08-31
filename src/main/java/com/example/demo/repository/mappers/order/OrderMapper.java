package com.example.demo.repository.mappers.order;

import com.example.demo.domain.entity.Order;
import com.example.demo.repository.mappers.Mapper;
import com.example.demo.repository.mappers.orderItem.OrderItemMapper;
import com.example.demo.repository.mappers.user.UserShortMapper;
import com.example.demo.web.dto.order.OrderDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper implements Mapper<Order, OrderDto> {
    private final UserShortMapper userShortMapper;
    private final OrderItemMapper orderItemMapper;

    public OrderMapper(UserShortMapper userShortMapper,OrderItemMapper orderItemMapper){
        this.userShortMapper=userShortMapper;
        this.orderItemMapper=orderItemMapper;
    }

    @Override
    public OrderDto mapTo(Order clazz) {
        return new OrderDto(
                clazz.getId(),
                clazz.getOrderDate(),
                clazz.getOrderStatus(),
                clazz.getTotalPrice(),
                userShortMapper.mapTo(clazz.getUser()),
                clazz.getItems().stream()
                        .map(orderItemMapper::mapTo)
                        .collect(Collectors.toList())

        );
    }
}
