package com.dexterv.financetracker.services.impl;

import com.dexterv.financetracker.domain.entities.User;
import com.dexterv.financetracker.domain.entities.UserRole;
import com.dexterv.financetracker.repositories.UserRepository;
import com.dexterv.financetracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public Page<User> getUsersByName(String name, Pageable pageable) {
        return userRepository.getAllUsersByNameContainingIgnoreCase(name, pageable);
    }
}
