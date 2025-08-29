package com.example.demo.services;

import com.example.demo.domain.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User update(User user);

    User deleteUserById(Long id);

    User findById(Long id);

    List<User> findAll();

    boolean updateUserEmailById(Long id, String email);

    List<User> findAllWithOrders();

    User findUserWithOrdersById(Long id);
}
