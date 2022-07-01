package com.websecu.security.Service.Impl;


import com.websecu.security.Domain.LoginRequest;
import com.websecu.security.Domain.LoginResponse;
import com.websecu.security.Domain.User;
import com.websecu.security.Dto.UserDto;
import com.websecu.security.Dto.UserDtoResponse;
import com.websecu.security.Repository.UserRepo;
import com.websecu.security.Security.JwtHelper;
import com.websecu.security.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor

public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtHelper jwtHelper;



    @Override
    public List<UserDto> findAll() {
        var users=userRepo.findAll();
        Type listType=new TypeToken<List<UserService>>(){}.getType();
        return modelMapper.map(users,listType);
    }

    @Override
    public UserDto findById(int id) {
        var user=userRepo.findById(id).orElseThrow();

        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto save(UserDto user) {
        var u=modelMapper.map(user, User.class);
        userRepo.save(u);

        return modelMapper.map(u,UserDto.class);
    }

    @Override
    public String remove(int id) {
        boolean t=userRepo.findById(id).isPresent();
        if(t==true) {
            userRepo.deleteById(id);
        }
        return "deleted";
    }
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Bad Credentials");
        }
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;

    }
}
