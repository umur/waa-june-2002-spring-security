package com.example.spring_jwt.Model;

import lombok.Data;

@Data
public class UsersModel {
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
