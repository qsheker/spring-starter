package com.example.demo.services;

import com.example.demo.domain.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    User save(User user);

    User update(User user);

    void deleteUserById(Long id);

    User findById(Long id);

    List<User> findAll();

    User updateUserEmailById(Long id, String email);

    List<User> findAllWithOrders();

    User findUserWithOrdersById(Long id);

    BigDecimal getTotalPriceOfUserProductById(Long id);
}
