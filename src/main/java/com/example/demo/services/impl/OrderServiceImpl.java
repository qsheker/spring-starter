package com.example.demo.services.impl;

import com.example.demo.domain.entity.Order;
import com.example.demo.enums.OrderStatus;
import com.example.demo.repository.OrderRepository;
import com.example.demo.services.OrderService;
import com.example.demo.web.dto.card.CardRequestDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @PreAuthorize("#id = authentication.principal.id or hasRole('ADMIN')")
    public List<Order> findOrderByUserId(Long id) {
        return orderRepository.findOrderByUserId(id);
    }

    @Override
    @PreAuthorize("#id = authentication.principal.id or hasRole('ADMIN')")
    public void deleteOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order with id: "+id+" not found"));
        orderRepository.delete(order);
    }

    @Override
    @PreAuthorize("#id = order.user.id or hasAnyRole('ADMIN')")
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @PreAuthorize("#id = authentication.principal.id or hasRole('ADMIN')")
    public Order findOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order with id: "+id+" not found"));
        return order;
    }

    @Override
    @Transactional
    @PreAuthorize("#id = authentication.principal.id")
    public Order payForOrder(Long id, CardRequestDto cardRequestDto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order with id: "+id+" not found"));
        order.setStatus(OrderStatus.PAID);
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    @PreAuthorize("#id = authentication.principal.id")
    public Order cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order with id: "+id+" not found"));
        order.setStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }
}
