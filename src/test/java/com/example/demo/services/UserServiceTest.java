package com.example.demo.services;


import com.example.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceTest {

    @Autowired
    private UserService userService;

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
}