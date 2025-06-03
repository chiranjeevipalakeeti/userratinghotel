package com.app.plkt.service.Impl;

import com.app.plkt.dto.UserDto;
import com.app.plkt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto getUserById(String uerId) {
        return null;
    }
}
