package com.example.demo.domain.entity;

import com.example.demo.domain.converter.OrderStatusConverter;
import com.example.demo.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@EqualsAndHashCode(exclude = "user")
public class Order extends BaseEntity{

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Convert(converter = OrderStatusConverter.class)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false,precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items = new HashSet<>();

    @PrePersist
    public void PrePersist() {
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.NEW;
    }

    public BigDecimal calculateTotalPrice() {
        return items.stream()
                .map(item->item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
