package com.example.lab_6_jwt.controller;

import com.example.lab_6_jwt.dto.UserDto;
import com.example.lab_6_jwt.dto.UserResponseDto;
import com.example.lab_6_jwt.service.UaaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private UaaService userService;

    public UserController(UaaService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        var users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        var userDto = userService.findById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@RequestBody UserDto userDto, @PathVariable Long id){
        userDto.setId(id);
        UserResponseDto userDtoResponse = userService.save(userDto);
        return ResponseEntity.ok(userDtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
