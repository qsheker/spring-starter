package com.example.demo.repository.mappers.user;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.user.UserDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper{

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
