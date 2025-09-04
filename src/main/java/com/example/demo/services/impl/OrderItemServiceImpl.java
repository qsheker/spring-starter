package com.example.demo.services.impl;

import com.example.demo.domain.entity.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.services.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository){
        this.orderItemRepository=orderItemRepository;
    }

    @Override
    public List<OrderItem> findByOrderId(Long id) {
        return orderItemRepository.findByOrderId(id);
    }

    @Override
    public List<OrderItem> findByProductId(Long id) {
        return orderItemRepository.findByProductId(id);
    }
}
