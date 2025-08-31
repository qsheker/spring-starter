package com.example.demo.repository.mappers.user;

import com.example.demo.domain.entity.User;
import com.example.demo.repository.mappers.Mapper;
import com.example.demo.web.dto.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public UserDto mapTo(User clazz) {
        return new UserDto(clazz.getId(),
                clazz.getName(),
                clazz.getEmail(),
                clazz.getRole());
    }
}
