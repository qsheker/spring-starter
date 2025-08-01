package com.example.demo;

import com.example.demo.bfpp.EnabledBeanRegistry;
import com.example.demo.pojo.User;
import com.example.demo.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DemoApplication {
	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("application.xml");
		var enabledBeanRegister = context.getBean("enabledBeanRegistry", EnabledBeanRegistry.class);
		var enabledBeanNames = enabledBeanRegister.getEnabledBeanNames();
		System.out.println(enabledBeanNames);
	}

}
