package com.example.lab5sec.controller;

import com.example.lab5sec.model.LoginRequest;
import com.example.lab5sec.model.LoginResponse;
import com.example.lab5sec.model.SignupRequest;
import com.example.lab5sec.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("signup")
    ResponseEntity<?> login(@RequestBody SignupRequest signupRequest) {
        var loginResponse = authService.signup(signupRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

}
