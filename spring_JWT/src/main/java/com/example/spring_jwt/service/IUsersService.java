package com.example.spring_jwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersService{
    UserDetails loadUserByUsername(String username);
}
