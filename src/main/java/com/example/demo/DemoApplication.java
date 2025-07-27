package com.example.demo;

import com.example.demo.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DemoApplication {

	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(context.getBean(User.class));
	}

}
