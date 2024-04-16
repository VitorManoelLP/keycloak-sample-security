package com.keycloak.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyAuthority('OPERATION_READ', 'OPERATION_WRITE')")
@RequestMapping("/api/operation")
public class OperationAccessController {

    @GetMapping
    public String get() {
        return "Hello OPERATION";
    }

}
