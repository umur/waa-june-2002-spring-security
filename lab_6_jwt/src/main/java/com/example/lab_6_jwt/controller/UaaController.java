package com.example.lab_6_jwt.controller;

import com.example.lab_6_jwt.dto.UserDto;
import com.example.lab_6_jwt.dto.UserResponseDto;
import com.example.lab_6_jwt.entity.LoginRequest;
import com.example.lab_6_jwt.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/uaa")
public class UaaController {

    private UaaService userService;

    public UaaController(UaaService uaaService) {
        this.userService = uaaService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserDto userDto){
        UserResponseDto userDtoResponse = userService.save(userDto);
        return ResponseEntity.ok(userDtoResponse);
    }
}
