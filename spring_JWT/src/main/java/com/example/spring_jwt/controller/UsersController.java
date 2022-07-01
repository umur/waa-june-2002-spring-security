package com.example.spring_jwt.controller;

import com.example.spring_jwt.Model.UsersModel;
import com.example.spring_jwt.entity.Users;
import com.example.spring_jwt.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    private IUsersService iUsersService;

    @Autowired
    public UsersController(IUsersService iUsersService) {
        this.iUsersService = iUsersService;
    }

    @PostMapping()
    public UsersModel save(@RequestBody UsersModel usersModel) {
        return new UsersModel();
    }

    @GetMapping()
    public List<Users> get() {
        List<Users> users = iUsersService.getUsers();
        return users;
    }

//    @GetMapping()
//    public ResponseEntity<List<Users>> get() {
//        List<Users> users = iUsersService.getUsers();
//        return ResponseEntity.ok(users);
//    }
}
