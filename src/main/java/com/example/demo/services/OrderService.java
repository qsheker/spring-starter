package com.example.demo.services;

import com.example.demo.domain.entity.Order;
import com.example.demo.enums.OrderStatus;

import java.util.List;

public interface OrderService {
    Order findOrderById(Long id);

    List<Order> findAll();

    Order save(Order order);

    void deleteOrderById(Long id);

    List<Order> findOrderByUserId(Long id);

    List<Order> findOrdersByOrderStatus(OrderStatus orderStatus);
}
