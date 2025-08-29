package com.example.demo.repositories;

import com.example.demo.domain.entity.Order;
import com.example.demo.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.user.id=:id")
    List<Order> findOrderByUserId(Long id);

    List<Order> findOrdersByOrderStatus(OrderStatus orderStatus);
}
