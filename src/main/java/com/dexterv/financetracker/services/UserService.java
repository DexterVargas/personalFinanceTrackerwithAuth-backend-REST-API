package com.dexterv.financetracker.services;

import com.dexterv.financetracker.domain.dtos.UserSignupRequestDto;
import com.dexterv.financetracker.domain.entities.User;

import java.util.Optional;

public interface UserService {
    User create(User user);

    Optional<User> getUserByEmail(String email);
}
