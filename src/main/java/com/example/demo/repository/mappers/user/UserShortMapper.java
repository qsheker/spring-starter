package com.example.demo.repository.mappers.user;

import com.example.demo.domain.entity.User;
import com.example.demo.repository.mappers.Mapper;
import com.example.demo.web.dto.user.UserShortDto;
import org.springframework.stereotype.Component;

@Component
public class UserShortMapper implements Mapper<User, UserShortDto> {
    @Override
    public UserShortDto mapTo(User clazz) {
        return new UserShortDto(
                clazz.getId(),
                clazz.getName(),
                clazz.getEmail()
        );
    }
}
