package com.websecu.security.Service;


import com.websecu.security.Domain.LoginRequest;
import com.websecu.security.Domain.LoginResponse;
import com.websecu.security.Dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    UserDto save(UserDto user);

    String remove(int id);

    LoginResponse login(LoginRequest loginRequest);
}
