package edu.miu.springsecurity.service;


import edu.miu.springsecurity.dto.*;

public interface UAAService {
    LoginDtoResponse login(LoginDtoRequest loginRequest);

    SignUpDtoResponse signup(SignUpDtoRequest signUpRequest);
}