package com.dexterv.financetracker.controllers;

import com.dexterv.financetracker.domain.dtos.UserResponseDto;
import com.dexterv.financetracker.domain.dtos.UserSignupRequestDto;
import com.dexterv.financetracker.domain.entities.User;
import com.dexterv.financetracker.mappers.UserMapper;
import com.dexterv.financetracker.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserMapper userMapper;
    private UserService userService;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping(path="/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserSignupRequestDto userSignupRequestDto) {

        User toEntity = userMapper.userSignupRequestFromDto(userSignupRequestDto);

        User savedUser = userService.create(toEntity);


    }
}
