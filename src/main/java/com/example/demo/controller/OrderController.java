package com.example.demo.controller;

import com.example.demo.domain.entity.Order;
import com.example.demo.enums.OrderStatus;
import com.example.demo.repository.mappers.order.OrderMapper;
import com.example.demo.repository.mappers.order.OrderRequestMapper;
import com.example.demo.repository.mappers.order.OrderShortMapper;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;
import com.example.demo.web.dto.card.CardRequestDto;
import com.example.demo.web.dto.order.OrderDto;
import com.example.demo.web.dto.order.OrderRequestDto;
import com.example.demo.web.dto.order.OrderShortDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final OrderShortMapper orderShortMapper;
    private final OrderRequestMapper orderRequestMapper;


    public OrderController(OrderService orderService, OrderMapper orderMapper, UserService userService, OrderShortMapper orderShortMapper, OrderRequestMapper orderRequestMapper){
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.orderShortMapper = orderShortMapper;
        this.orderRequestMapper = orderRequestMapper;
    }

    @GetMapping
    public List<OrderDto> getAllOrders(){
        return orderService.findAll()
                .stream()
                .map(order -> orderMapper.toDto(order))
                .toList();
    }
    @GetMapping("/status/{status}")
    public List<OrderDto> getAllByOrderStatus(@PathVariable("status")OrderStatus status){
        return orderService.findOrdersByOrderStatus(status)
                .stream()
                .map(order -> orderMapper.toDto(order))
                .toList();
    }
    @GetMapping("/users/{userId}")
    public List<OrderDto> getUserOrders(@PathVariable("userId") Long id){
        return orderService.findOrderByUserId(id)
                .stream()
                .map(order -> orderMapper.toDto(order))
                .toList();
    }
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long id){
        orderService.deleteOrderById(id);
    }

    @PostMapping
    public OrderShortDto create(@RequestBody OrderRequestDto orderRequestDto){
        Order order = orderRequestMapper.toEntity(orderRequestDto);
        Order saved = orderService.save(order);
        return orderShortMapper.toDto(saved);
    }
    @GetMapping("/{orderId}")
    public OrderShortDto gerOrderById(@PathVariable("orderId") Long id){
        Order order = orderService.findOrderById(id);
        return orderShortMapper.toDto(order);
    }
    @PostMapping("/{id}/pay")
    public OrderShortDto payForOrder(@PathVariable("id") Long id, @Validated @RequestBody CardRequestDto cardRequestDto){
        Order order = orderService.payForOrder(id, cardRequestDto);
        return orderShortMapper.toDto(order);
    }
    @PostMapping("/{id}/cancel")
    public OrderShortDto cancelOrder(@PathVariable("id") Long id){
        Order order = orderService.cancelOrder(id);
        return orderShortMapper.toDto(order);
    }
}
