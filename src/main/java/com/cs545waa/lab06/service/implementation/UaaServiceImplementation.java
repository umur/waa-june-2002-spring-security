package com.cs545waa.lab06.service.implementation;

import com.cs545waa.lab06.model.LoginRequest;
import com.cs545waa.lab06.model.LoginResponse;
import com.cs545waa.lab06.model.RefreshRequest;
import com.cs545waa.lab06.service.UaaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UaaServiceImplementation implements UaaService {
  //  private final AuthenticationManager authenticationManager;
    //private final UserDetailsService userDetailsService;

    @Override
    public LoginResponse login(LoginRequest credential) {
        return null;
    }

    @Override
    public LoginResponse refreshToken(RefreshRequest refreshRequest) {
        return null;
    }
}
