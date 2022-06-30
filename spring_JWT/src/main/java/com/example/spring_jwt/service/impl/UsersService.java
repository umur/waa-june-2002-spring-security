package com.example.spring_jwt.service.impl;

import com.example.spring_jwt.entity.Users;
import com.example.spring_jwt.repository.IUserRepository;
import com.example.spring_jwt.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsersService implements UserDetailsService, IUsersService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var result = iUserRepository.findByUsername("apokhrel@miu.edu");
        return null;
    }

    public Users findByUsername(String username) {
        var result = iUserRepository.findByUsername("apokhrel@miu.edu");
        return result;
    }

    public List<Users> getUsers() {
        List<Users> users = iUserRepository.findAll();
        return users;
    }
}
