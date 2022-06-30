package com.example.spring_jwt.controller;

import com.example.spring_jwt.Model.LoginModel;
import com.example.spring_jwt.Model.ResponseModel;
import com.example.spring_jwt.service.IloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class LoginController {
    private IloginService iloginService;

    @Autowired
    public LoginController(IloginService iloginService)
    {
        this.iloginService = iloginService;
    }

    @PostMapping("/login")
    public ResponseModel login(@RequestBody LoginModel loginModel)
    {
        return iloginService.login(loginModel);
    }

    @GetMapping("/login")
    public String get()
    {
        return  "GETTTS";
    }
}
