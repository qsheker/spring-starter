package com.example.demo.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.mappers.user.Director.UserDirector;
import com.example.demo.web.dto.mappers.user.UserMapper;
import com.example.demo.web.dto.mappers.user.UserOrderMapper;
import com.example.demo.web.dto.mappers.user.UserRequestMapper;
import com.example.demo.web.dto.mappers.user.UserShortMapper;
import com.example.demo.services.UserService;
import com.example.demo.web.dto.user.*;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserOrderMapper userOrderMapper;
    private final UserRequestMapper userRequestMapper;
    private final UserShortMapper userShortMapper;
    private final UserDirector userDirector;

    public UserController(UserService userService, UserMapper userMapper, UserOrderMapper userOrderMapper, UserRequestMapper userRequestMapper, UserShortMapper userShortMapper, UserDirector userDirector){
        this.userService=userService;
        this.userMapper=userMapper;
        this.userOrderMapper = userOrderMapper;
        this.userRequestMapper = userRequestMapper;
        this.userShortMapper = userShortMapper;
        this.userDirector = userDirector;
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
    public UserDto update(@PathVariable Long id,@Valid @RequestBody  UserRequestDto userRequestDto){
        User user = userRequestMapper.toEntity(userRequestDto);
        user.setId(id);
        User updated = userService.save(user);
        return userMapper.toDto(updated);
    }
    @PostMapping("/register")
    public UserShortDto register(@Valid @RequestBody UserRequestDto userRequestDto){
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
    public UserTotalPriceDto getTotalPriceOfUserOrderById(@PathVariable("id") Long id){
        BigDecimal total = userService.getTotalPriceOfUserProductById(id);
        User user = userService.findById(id);
        UserTotalPriceDto userTotalPriceDto = userDirector.createUserWithTotalPrice(total, user);
        return userTotalPriceDto;
    }
}
