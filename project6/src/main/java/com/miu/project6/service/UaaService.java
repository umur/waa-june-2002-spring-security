package com.miu.project6.service;

public interface UaaService {
    LoginDtoResponse login(LoginDtoRequest loginRequest);

    LoginDtoResponse refreshToken(RefreshTokenDtoRequest refreshTokenRequest);

    SignUpDtoResponse signup(SignUpDtoRequest signUpRequest);
}