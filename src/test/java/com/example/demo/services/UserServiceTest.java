package com.example.demo.services;


import com.example.demo.DemoApplication;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceTest {

     static final Long ID = 1L;

    @Autowired
    private UserService userService;

    @Test
    void testDto(){
        var user = userService.findUserById(ID);
        assertEquals(true, user.isPresent());
    }

    @Test
    void findAll() {
        var users = userService.findAll();
        assertEquals(3,users.size());
    }

    @Test
    void updateUserEmailById() {
        boolean updated = userService.updateUserEmailById(1L,"MaxWebber@gmail.com");
        assertEquals(false,updated);
    }
    @Test
    void testOrders(){
        List<User> userList = userService.findAllWithOrders();
        Optional<User> user = userService.findUserWithOrdersById(ID);

        assertEquals(3,userList.size());
        assertEquals(true,user.isPresent());
    }
}