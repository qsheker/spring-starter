package com.example.demo.repository.mappers.user;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.user.UserShortDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserShortMapper{
    UserShortDto toDto(User user);

    User toEntity(UserShortDto userDto);
}
