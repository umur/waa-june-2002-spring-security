package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.model.LoginResponse;
import edu.miu.springsecurity1.model.RefreshTokenRequest;
import edu.miu.springsecurity1.service.UaaService;
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
    //http://localhost:8080/api/v1/uaa?email=john@miu.edu
    @PostMapping
    public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest) {
        System.out.println("signin_start");
        System.out.println("email="+loginRequest.getEmail());
        System.out.println("password="+loginRequest.getPassword());
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup() {
        System.out.println("signout_start");
        var logoutResponse = uaaService.logout();
        System.out.println("signout_end");
        return ResponseEntity.ok().body(logoutResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        System.out.println("refreshToken_start");
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
