package com.anuj.finance.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.finance.backend.dto.ErrorResponse;
import com.anuj.finance.backend.dto.UserRequest;
import com.anuj.finance.backend.dto.UserResponse;
import com.anuj.finance.backend.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')") // this is not required for creating admin user for the first time and should not be removed later
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<ErrorResponse> deactivateUser(@PathVariable Long id) {

        String message = userService.deactivateUser(id);

        return ResponseEntity.ok(
                ErrorResponse.builder()
                        .error("SUCCESS")
                        .message(message)
                        .build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/activate")
    public ResponseEntity<ErrorResponse> activateUser(@PathVariable Long id) {

        String message = userService.activateUser(id);

        return ResponseEntity.ok(
                ErrorResponse.builder()
                        .error("SUCCESS")
                        .message(message)
                        .build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}/delete") 
    public ResponseEntity<ErrorResponse> deleteUser(@PathVariable Long id) {

        String message = userService.deleteUser(id);

        return ResponseEntity.ok(
                ErrorResponse.builder()
                        .error("SUCCESS")
                        .message(message)
                        .build());
    }
}