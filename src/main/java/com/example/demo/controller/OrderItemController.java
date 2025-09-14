package com.example.demo.controller;

import com.example.demo.web.dto.mappers.orderItem.OrderItemMapper;
import com.example.demo.services.OrderItemService;
import com.example.demo.web.dto.orderItem.OrderItemDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders/items")
public class OrderItemController {
    private final OrderItemMapper orderItemMapper;
    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemMapper orderItemMapper, OrderItemService orderItemService) {
        this.orderItemMapper = orderItemMapper;
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItemDto> getOrderItemByOrderId(@PathVariable("orderId") Long id){
        return orderItemService.findByOrderId(id).stream()
                .map(orderItem -> orderItemMapper.toDto(orderItem))
                .toList();
    }
    @GetMapping("/product/{productId}")
    public List<OrderItemDto> getOrderItemByProductId(@PathVariable("productId") Long id){
        return orderItemService.findByProductId(id).stream()
                .map(orderItem -> orderItemMapper.toDto(orderItem))
                .toList();
    }

}
