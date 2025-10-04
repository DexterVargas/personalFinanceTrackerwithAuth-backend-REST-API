package com.dexterv.financetracker.controllers;

import com.dexterv.financetracker.domain.dtos.UserSignupResponseDto;
import com.dexterv.financetracker.domain.dtos.UserSignupRequestDto;
import com.dexterv.financetracker.domain.entities.User;
import com.dexterv.financetracker.mappers.UserMapper;
import com.dexterv.financetracker.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping(path="/signup")
    public ResponseEntity<UserSignupResponseDto> signup(
            @Valid
            @RequestBody UserSignupRequestDto userSignupRequestDto
    ) {

        // DTO → Entity
        User toEntity = userMapper.userSignupRequestFromDto(userSignupRequestDto);
        // Save via service
        User savedUser = userService.create(toEntity);


        // convert User Entity Response > Dto
        UserSignupResponseDto responseDto = userMapper.userSignupResponseToDto(savedUser);

        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }
}
