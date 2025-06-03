package com.app.plkt.mapper;

import com.app.plkt.dto.UserDto;
import com.app.plkt.model.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    public static final ModelMapper MAPPER= new ModelMapper();

    public static UserDto toDto(User user)
    {
        return MAPPER.map(user,UserDto.class);
    }
    public static  User toEntity(UserDto userDto)
    {
        return MAPPER.map(userDto,User.class);
    }
}
