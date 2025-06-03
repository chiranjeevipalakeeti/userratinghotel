package com.app.plkt.service.Impl;

import com.app.plkt.dto.UserDto;
import com.app.plkt.mapper.UserMapper;
import com.app.plkt.model.User;
import com.app.plkt.repository.UserRepository;
import com.app.plkt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user= UserMapper.toEntity(userDto);
        User save= userRepository.save(user);
        UserDto dto= UserMapper.toDto(save);
        return dto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
        UserDto userDto= UserMapper.toDto(user);
        return userDto;
    }
}
