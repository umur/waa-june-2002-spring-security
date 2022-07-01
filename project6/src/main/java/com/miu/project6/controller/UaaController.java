package com.miu.project6.controller;

<<<<<<< HEAD
import com.miu.project6.service.UaaService;
=======
import com.miu.project6.dto.*;
import com.miu.project6.service.UaaService;
import org.springframework.http.HttpStatus;
>>>>>>> 1c2689e19932194540cef4ba3b59e80a1a79f6d1
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {
    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
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

    @PostMapping("/refreshToken")
    public LoginDtoResponse refreshToken(@RequestBody RefreshTokenDtoRequest refreshTokenRequest) {
        return uaaService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/signup")
    public SignUpDtoResponse signup(@RequestBody SignUpDtoRequest signUpRequest) {
        return uaaService.signup(signUpRequest);
    }
}