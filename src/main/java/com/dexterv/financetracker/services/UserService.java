package com.dexterv.financetracker.services;

import com.dexterv.financetracker.domain.dtos.UserSignupRequestDto;
import com.dexterv.financetracker.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    User create(User user);

    Optional<User> getUserByEmail(String email);

    Page<User> getUsersByName(String name, Pageable pageable);
}
