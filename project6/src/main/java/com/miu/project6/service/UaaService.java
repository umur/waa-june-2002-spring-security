package com.miu.project6.service;


import com.miu.project6.model.LoginRequest;
import com.miu.project6.model.LoginResponse;
import com.miu.project6.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
