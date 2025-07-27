package com.example.demo;

import com.example.demo.pojo.User;
import com.example.demo.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DemoApplication {
	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("application.xml");
//		var userService = context.getBean("userService", UserService.class);
//		System.out.println(userService);
		var user = context.getBean("user1");
		System.out.println(user);
	}

}
