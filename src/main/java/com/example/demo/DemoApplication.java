package com.example.demo;


import com.example.demo.config.ApplicationConfiguration;
import com.example.demo.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DemoApplication {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		var userService = context.getBean("userService", UserService.class);
		System.out.println(userService);
	}
}
