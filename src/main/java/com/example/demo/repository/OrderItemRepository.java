package com.example.demo.repositories;


import com.example.demo.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long id);
    List<OrderItem> findByProductId(Long id);
}
