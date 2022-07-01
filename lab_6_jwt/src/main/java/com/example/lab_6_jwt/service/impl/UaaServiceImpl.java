package com.example.lab_6_jwt.service.impl;

import com.example.lab_6_jwt.dto.UserDto;
import com.example.lab_6_jwt.dto.UserResponseDto;
import com.example.lab_6_jwt.entity.LoginRequest;
import com.example.lab_6_jwt.entity.LoginResponse;
import com.example.lab_6_jwt.entity.User;
import com.example.lab_6_jwt.repository.UserRepository;
import com.example.lab_6_jwt.security.JwtHelper;
import com.example.lab_6_jwt.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UaaServiceImpl implements UaaService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        var users = userRepository.findAll();
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        return modelMapper.map(users,listType);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("User does not exist %s",id)));
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    /*
        todo we are converting the userDto type to userDtResponse type
     */
    @Override
    public UserResponseDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user = userRepository.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Bad Credentials");
        }
        /*todo -> encoding the username
                 regenerating the token we have
                 we are giving back the (refreshed token)token to the user
        */

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;

    }
}
