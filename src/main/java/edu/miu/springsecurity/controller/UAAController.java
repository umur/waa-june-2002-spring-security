package edu.miu.springsecurity.controller;


import edu.miu.springsecurity.dto.*;
import edu.miu.springsecurity.service.UAAService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UAAController {
  private final UAAService uaaService;

  public UAAController(UAAService uaaService) {
    this.uaaService = uaaService;
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginDtoRequest loginRequest) {
    try {
      var loginResponse = uaaService.login(loginRequest);
      return ResponseEntity.ok().body(loginResponse);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginFailedDtoResponse("Login failed"));
    }
  }

  @PostMapping("/signup")
  public SignUpDtoResponse signup(@RequestBody SignUpDtoRequest signUpRequest) {
    return uaaService.signup(signUpRequest);
  }
}
