package com.dexterv.financetracker.services.impl;

import com.dexterv.financetracker.domain.entities.User;
import com.dexterv.financetracker.domain.entities.UserRole;
import com.dexterv.financetracker.repositories.UserRepository;
import com.dexterv.financetracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        user.setRole(UserRole.USER);

        User savedUser = userRepository.save(user);
        userRepository.flush(); // ensure audit fields populated

        return savedUser;
    }
}
