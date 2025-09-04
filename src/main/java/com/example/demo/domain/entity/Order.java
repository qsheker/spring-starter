package com.example.demo.domain.entity;

import com.example.demo.domain.converter.OrderStatusConverter;
import com.example.demo.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
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
    private List<OrderItem> items = new ArrayList<>();

    @PrePersist
    public void PrePersist() {
        this.orderDate = LocalDateTime.now();
    }

    public BigDecimal calculateTotalPrice() {
        return items.stream()
                .map(item->item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
