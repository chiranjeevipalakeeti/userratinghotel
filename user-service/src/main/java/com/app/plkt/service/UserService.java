package com.app.plkt.service;

import com.app.plkt.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto );
    List<UserDto> getAllUsers();
    UserDto getUserById(String uerId);
}
