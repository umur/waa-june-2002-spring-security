package com.example.spring_jwt.controller;

import com.example.spring_jwt.Model.LoginRequest;
import com.example.spring_jwt.Model.LoginResponse;
import com.example.spring_jwt.Model.RefreshTokenRequest;
import com.example.spring_jwt.service.IUaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {

    private final IUaaService IUaaService;

    public UaaController(IUaaService IUaaService) {
        this.IUaaService = IUaaService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = IUaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return IUaaService.refreshToken(refreshTokenRequest);
    }

}
