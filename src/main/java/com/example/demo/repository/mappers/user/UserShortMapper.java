package com.example.demo.repository.mappers.user;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.user.UserShortDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserShortMapper{
    UserShortDto toDto(User user);

    User toEntity(UserShortDto userDto);
}
