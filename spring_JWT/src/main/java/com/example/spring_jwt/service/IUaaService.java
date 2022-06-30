package com.example.spring_jwt.service;

import com.example.spring_jwt.Model.LoginRequest;
import com.example.spring_jwt.Model.LoginResponse;
import com.example.spring_jwt.Model.RefreshTokenRequest;

public interface IUaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
