package com.example.demo.config;

import com.example.demo.config.condition.devConditional;
import com.example.demo.config.condition.prodConditional;
import com.example.demo.pojo.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public User user1(@Value("${user.firstname}") String firstName,
                      @Value("${user.lastname}") String lastName,
                      @Value("${user.email}") String email,
                      @Value("${user.optional.enabled}") boolean enabled) {
        return new User(firstName, lastName, email, enabled);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public UserRepository userRepository1() {
        return new UserRepository();
    }

    @Bean
    public UserService userService(UserRepository userRepository1) {
        return new UserService(userRepository1);
    }
    @Bean
    @Conditional(devConditional.class)
    public User dev1(){
        System.out.println("hello from dev");
        return new User("Aldiyar","Maksutov","bober@mail.com",true);
    }
    @Bean
    @Conditional(prodConditional.class)
    public User prod1(){
        System.out.println("hello from prod");
        return new User("Madiyar","Maksutov","bober@mail.com",true);
    }

}
