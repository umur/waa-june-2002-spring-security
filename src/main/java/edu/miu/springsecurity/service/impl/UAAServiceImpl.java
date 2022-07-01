package edu.miu.springsecurity.service.impl;

import edu.miu.springsecurity.domain.Role;
import edu.miu.springsecurity.domain.User;

import edu.miu.springsecurity.repo.RoleRepo;
import edu.miu.springsecurity.repo.UserRepo;
import edu.miu.springsecurity.security.helper.JwtHelper;
import edu.miu.springsecurity.service.UAAService;
import edu.miu.springsecurity.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class UAAServiceImpl implements UAAService {
  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;
  private final UserRepo userRepo;
  private final RoleRepo roleRepo;

  private final JwtHelper jwtHelper;

  @Override
  public LoginDtoResponse login(LoginDtoRequest loginRequest) {
    try {
      var result = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
          loginRequest.getPassword())
      );

    } catch (BadCredentialsException e) {
      log.info("Bad Credentials");
      throw e;
    }

    final String accessToken = jwtHelper.generateToken(loginRequest.getUserName());
    var loginResponse = new LoginDtoResponse(accessToken);
    return loginResponse;
  }

  @Override
  public SignUpDtoResponse signup(SignUpDtoRequest signUpRequest) {
    User user = new User();
    user.setUserName(signUpRequest.getUserName());
    user.setFirstName(signUpRequest.getFirstName());
    user.setLastName(signUpRequest.getLastName());

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    var encodedPwd = passwordEncoder.encode(signUpRequest.getPassword());
    user.setPassword(encodedPwd);

    var userRole = roleRepo.findById(signUpRequest.getRoleId()).orElse(null);
    var roles = new ArrayList<Role>();
    roles.add(userRole);
    user.setRole(roles);

    userRepo.save(user);
    return new SignUpDtoResponse(user);
  }
}
