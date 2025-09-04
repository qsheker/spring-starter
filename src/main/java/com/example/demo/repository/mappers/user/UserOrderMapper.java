package com.example.demo.repository.mappers.user;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.user.UserOrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserOrderMapper {
    UserOrderDto toDto(User user);

    User toEntity(UserOrderDto userDto);
}
