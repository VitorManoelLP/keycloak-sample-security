package com.keycloak.example.service;

import com.keycloak.example.domain.User;
import org.springframework.http.ResponseEntity;

public interface AuthManager {
    ResponseEntity<?> login(User user);
    ResponseEntity<?> refresh(String refreshToken);
}
