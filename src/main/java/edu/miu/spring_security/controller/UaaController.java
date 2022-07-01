package edu.miu.spring_security.controller;

import edu.miu.spring_security.model.LoginRequest;
import edu.miu.spring_security.model.LoginResponse;
import edu.miu.spring_security.model.RefreshTokenRequest;
import edu.miu.spring_security.service.UaaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {

    @Autowired
    private UaaService uaaService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return uaaService.refreshToken(refreshTokenRequest);
    }



}
