package com.keycloak.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyAuthority('ADMIN_READ', 'ADMIN_WRITE')")
@RequestMapping("/api/admin")
public class AdminAccessController {

    @GetMapping
    public String get() {
        return "Hello ADMIN";
    }

}
