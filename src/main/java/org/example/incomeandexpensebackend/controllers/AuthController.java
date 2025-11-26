package org.example.incomeandexpensebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.incomeandexpensebackend.dtos.auth.AuthResponseDto;
import org.example.incomeandexpensebackend.dtos.auth.LoginDto;
import org.example.incomeandexpensebackend.services.interfaces.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        AuthResponseDto response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

}
