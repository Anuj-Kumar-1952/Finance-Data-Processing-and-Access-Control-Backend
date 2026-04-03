package com.anuj.finance.backend.service;

import java.util.List;

import com.anuj.finance.backend.dto.UserRequest;
import com.anuj.finance.backend.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    String deactivateUser(Long userId);

    String activateUser(Long userId);

    String deleteUser(Long userId);
}