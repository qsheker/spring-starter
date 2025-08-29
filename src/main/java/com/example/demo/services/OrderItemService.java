package com.example.demo.services;

import com.example.demo.domain.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> findByOrderId(Long orderId);
    List<OrderItem> findByProductId(Long productId);
}
