package com.example.lab_6_jwt.service;

import com.example.lab_6_jwt.dto.UserDto;
import com.example.lab_6_jwt.dto.UserResponseDto;
import com.example.lab_6_jwt.entity.LoginRequest;
import com.example.lab_6_jwt.entity.LoginResponse;

import java.util.List;

public interface UaaService {

    List<UserDto> findAll();
    UserDto findById(Long id);
    UserResponseDto save(UserDto user);
    void remove(Long id);
    LoginResponse login(LoginRequest loginRequest);
}
