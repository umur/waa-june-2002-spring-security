package edu.miu.waa_lab6_a.controller;

import edu.miu.waa_lab6_a.viewmodel.LoginRequest;
import edu.miu.waa_lab6_a.viewmodel.LoginResponse;
import edu.miu.waa_lab6_a.viewmodel.RefreshTokenRequest;
import edu.miu.waa_lab6_a.service.IUaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {

    private final IUaaService uaaService;

    public UaaController(IUaaService uaaService) {
        this.uaaService = uaaService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
