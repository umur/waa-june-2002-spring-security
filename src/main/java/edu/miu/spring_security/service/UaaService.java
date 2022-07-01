package edu.miu.spring_security.service;

import edu.miu.spring_security.model.LoginRequest;
import edu.miu.spring_security.model.LoginResponse;
import edu.miu.spring_security.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
