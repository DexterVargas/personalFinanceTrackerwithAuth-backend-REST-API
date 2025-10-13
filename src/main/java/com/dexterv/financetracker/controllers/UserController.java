package com.dexterv.financetracker.controllers;

import com.dexterv.financetracker.domain.dtos.UserResponseDto;
import com.dexterv.financetracker.domain.dtos.UserSignupResponseDto;
import com.dexterv.financetracker.domain.dtos.UserSignupRequestDto;
import com.dexterv.financetracker.domain.entities.User;
import com.dexterv.financetracker.mappers.UserMapper;
import com.dexterv.financetracker.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path="/{email}")
    public ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable("email") String email) {

        User entity = userService.getUserByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("User with email " + email + " not found")
        );

        UserResponseDto responseDto = userMapper.userToUserResponseDto(entity);

        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    // This method will be used by admin
    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getAllUsers(
            @RequestParam(required = false) String name,
            Pageable pageable
    ) {
        Page<User> users = userService.getUsersByName(name, pageable);

        return ResponseEntity.ok(
                users.map(userMapper::userToUserResponseDto)
        );
    }
}
