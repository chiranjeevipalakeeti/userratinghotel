package com.app.plkt.controller;

import com.app.plkt.dto.ApiResponse;
import com.app.plkt.dto.UserDto;
import com.app.plkt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
@PostMapping("/create")
    public ResponseEntity<ApiResponse<UserDto>> save(@RequestBody UserDto userDto)
    {
        ApiResponse<UserDto> response= new ApiResponse<>();
        UserDto dto= userService.saveUser(userDto);
        response.setStatusCode(200);
        response.setMessage("User Created");
        response.setData(dto);
        return  ResponseEntity.ok().body(response);

    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<ApiResponse<UserDto>> getUser(@PathVariable Long userId)
    {
        ApiResponse<UserDto> response= new ApiResponse<>();
        UserDto userDto= userService.getUserById(userId);
        response.setMessage("User Created");
        response.setData(userDto);
        return  ResponseEntity.ok().body(response);
    }
}
