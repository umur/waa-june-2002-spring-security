package com.example.spring_jwt.service;

import com.example.spring_jwt.entity.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUsersService{
    Users findByUsername(String username);
    List<Users> getUsers();
}
