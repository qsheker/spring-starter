package com.example.demo.repository;

import com.example.demo.domain.entity.Order;
import com.example.demo.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.user.id=:id")
    List<Order> findOrderByUserId(Long id);

    List<Order> findOrderByStatus(OrderStatus status);
}
