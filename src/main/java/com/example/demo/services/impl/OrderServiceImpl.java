package com.example.demo.services.impl;

import com.example.demo.domain.entity.Order;
import com.example.demo.enums.OrderStatus;
import com.example.demo.repository.OrderRepository;
import com.example.demo.services.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findOrderByStatus(orderStatus);
    }

    @Override
    public List<Order> findOrderByUserId(Long id) {
        return orderRepository.findOrderByUserId(id);
    }

    @Override
    public void deleteOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order with id: "+id+" not found"));
        orderRepository.delete(order);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order with id: "+id+" not found"));
        return order;
    }
}
