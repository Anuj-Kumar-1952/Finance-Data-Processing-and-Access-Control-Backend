package com.anuj.finance.backend.dto;

import com.anuj.finance.backend.entity.Role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private boolean active;
}