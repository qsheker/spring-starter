package com.example.demo.repository.mappers.user;

import com.example.demo.domain.entity.User;
import com.example.demo.repository.mappers.order.OrderMapper;
import com.example.demo.web.dto.user.UserOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderMapper.class})
public interface UserOrderMapper {
    UserOrderDto toDto(User user);

    User toEntity(UserOrderDto userDto);
}
