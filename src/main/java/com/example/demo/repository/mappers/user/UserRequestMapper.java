package com.example.demo.repository.mappers.user;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.user.UserRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    UserRequestDto toDto(User user);

    User toEntity(UserRequestDto userRequestDto);
}
