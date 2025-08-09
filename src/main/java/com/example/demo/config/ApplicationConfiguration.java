package com.example.demo.config;

import com.example.demo.pojo.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example.demo",
        useDefaultFilters = true,
        includeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION)
)
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
    public UserService userService() {
        return new UserService(userRepository1());
    }

}
