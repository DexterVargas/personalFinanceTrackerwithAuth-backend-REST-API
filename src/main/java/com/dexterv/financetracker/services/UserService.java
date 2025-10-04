package com.dexterv.financetracker.services;

import com.dexterv.financetracker.domain.dtos.UserSignupRequestDto;
import com.dexterv.financetracker.domain.entities.User;

public interface UserService {
    User create(User user);
}
