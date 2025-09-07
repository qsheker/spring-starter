package com.example.demo.controller;

import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.User;
import com.example.demo.repository.mappers.user.UserMapper;
import com.example.demo.repository.mappers.user.UserOrderMapper;
import com.example.demo.repository.mappers.user.UserRequestMapper;
import com.example.demo.repository.mappers.user.UserShortMapper;
import com.example.demo.services.UserService;
import com.example.demo.web.dto.user.UserDto;
import com.example.demo.web.dto.user.UserOrderDto;
import com.example.demo.web.dto.user.UserRequestDto;
import com.example.demo.web.dto.user.UserShortDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserOrderMapper userOrderMapper;
    private final UserRequestMapper userRequestMapper;
    private final UserShortMapper userShortMapper;

    public UserController(UserService userService, UserMapper userMapper, UserOrderMapper userOrderMapper, UserRequestMapper userRequestMapper, UserShortMapper userShortMapper){
        this.userService=userService;
        this.userMapper=userMapper;
        this.userOrderMapper = userOrderMapper;
        this.userRequestMapper = userRequestMapper;
        this.userShortMapper = userShortMapper;
    }

    @GetMapping
    public List<UserDto> findAll(){
        List<User> users = userService.findAll();
        List<UserDto> userDtos = users.stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());
        return userDtos;
    }

    @GetMapping("/orders")
    public List<UserOrderDto> findAllWithOrders(){
        List<User> users = userService.findAllWithOrders();
        List<UserOrderDto> userOrderDtos = users.stream()
                .map(user -> userOrderMapper.toDto(user))
                .collect(Collectors.toList());
        return userOrderDtos;
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable("id") Long id){
        User user = userService.findById(id);
        return userMapper.toDto(user);
    }

    @GetMapping("/orders/{id}")
    public UserOrderDto findUserWithOrdersById(@PathVariable("id") Long id){
        User user = userService.findUserWithOrdersById(id);
        return userOrderMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }
    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody  UserRequestDto userRequestDto){
        User user = userRequestMapper.toEntity(userRequestDto);
        user.setId(id);
        User updated = userService.save(user);
        return userMapper.toDto(updated);
    }
    @PostMapping
    public UserShortDto create( @RequestBody UserRequestDto userRequestDto){
        User user = userRequestMapper.toEntity(userRequestDto);
        User saved = userService.save(user);
        return userShortMapper.toDto(saved);
    }
    @PatchMapping("/{id}/{email}")
    public UserShortDto updateEmail(@PathVariable Long id,@PathVariable String email){
        User user = userService.updateUserEmailById(id,email);
        return userShortMapper.toDto(user);
    }
    @GetMapping("orders/total/{id}")
    public BigDecimal getTotalPriceOfUserProductById(@PathVariable("id") Long id){
        User user = userService.findById(id);
        Set<Order> orders = user.getOrders();
        return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
