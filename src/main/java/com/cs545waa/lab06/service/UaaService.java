package com.cs545waa.lab06.service;

import com.cs545waa.lab06.model.LoginRequest;
import com.cs545waa.lab06.model.LoginResponse;
import com.cs545waa.lab06.model.RefreshRequest;

public interface UaaService {
    LoginResponse login(LoginRequest credential);
    LoginResponse refreshToken(RefreshRequest refreshRequest);
}
