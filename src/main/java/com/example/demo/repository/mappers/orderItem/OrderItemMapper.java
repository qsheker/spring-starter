package com.example.demo.repository.mappers.orderItem;

import com.example.demo.domain.entity.OrderItem;
import com.example.demo.repository.mappers.Mapper;
import com.example.demo.repository.mappers.product.ProductMapper;
import com.example.demo.web.dto.orderItem.OrderItemDto;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper implements Mapper<OrderItem, OrderItemDto> {
    private final ProductMapper productMapper;

    public OrderItemMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public OrderItemDto mapTo(OrderItem clazz) {
        return new OrderItemDto(
                clazz.getId(),
                clazz.getPrice(),
                clazz.getQuantity(),
                productMapper.mapTo(clazz.getProduct())
        );
    }
}
