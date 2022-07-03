package miu.edu.springsecurity.controller;

import miu.edu.springsecurity.domain.LoginRequest;
import miu.edu.springsecurity.dto.UserDto;
import miu.edu.springsecurity.dto.UserDtoResponse;
import miu.edu.springsecurity.service.UserService;
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

    @PostMapping("/signup")
    public ResponseEntity<UserDtoResponse> signup(@RequestBody UserDto userDto){
        UserDtoResponse userDtoResponse = userService.save(userDto);
        return ResponseEntity.ok(userDtoResponse);
    }

}
