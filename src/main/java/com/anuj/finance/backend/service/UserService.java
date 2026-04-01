package com.anuj.finance.backend.service;

import java.util.List;

import com.anuj.finance.backend.dto.UserRequest;
import com.anuj.finance.backend.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<UserResponse> getAllUsers();

    void deactivateUser(Long userId);
}