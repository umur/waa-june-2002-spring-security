package edu.miu.waa_lab6_a.service;

import edu.miu.waa_lab6_a.viewmodel.LoginRequest;
import edu.miu.waa_lab6_a.viewmodel.LoginResponse;
import edu.miu.waa_lab6_a.viewmodel.RefreshTokenRequest;

public interface IUaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
