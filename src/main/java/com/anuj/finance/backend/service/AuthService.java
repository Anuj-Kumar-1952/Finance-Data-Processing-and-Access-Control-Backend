package com.anuj.finance.backend.service;

import com.anuj.finance.backend.dto.AuthRequest;
import com.anuj.finance.backend.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
}