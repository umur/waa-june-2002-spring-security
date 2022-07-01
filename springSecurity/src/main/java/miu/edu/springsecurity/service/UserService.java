package miu.edu.springsecurity.service;

import miu.edu.springsecurity.domain.LoginRequest;
import miu.edu.springsecurity.domain.LoginResponse;
import miu.edu.springsecurity.dto.UserDto;
import miu.edu.springsecurity.dto.UserDtoResponse;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDtoResponse save(UserDto user);

    void remove(Long id);

    LoginResponse login(LoginRequest loginRequest);

}
