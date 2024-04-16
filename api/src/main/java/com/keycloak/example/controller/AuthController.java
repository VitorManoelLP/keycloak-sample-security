package com.keycloak.example.controller;

import com.keycloak.example.domain.User;
import com.keycloak.example.service.AuthManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthManager authManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid User user) {
        return authManager.login(user);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> login(@RequestParam("refresh_token") String refreshToken) {
        return authManager.refresh(refreshToken);
    }

}
