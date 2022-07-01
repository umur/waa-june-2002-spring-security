package com.websecu.security.Controller;

import com.websecu.security.Domain.LoginRequest;
import com.websecu.security.Dto.UserDto;
import com.websecu.security.Dto.UserDtoResponse;
import com.websecu.security.Service.Impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/uaa")
public class UaaController {

    private UserService userService;

    public UaaController(UserService uaaService) {
        this.userService = uaaService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }
// UserDtoResponse should return
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody UserDto userDto){
        UserDto userDtoResponse = userService.save(userDto);
        return ResponseEntity.ok(userDto);
    }

}
