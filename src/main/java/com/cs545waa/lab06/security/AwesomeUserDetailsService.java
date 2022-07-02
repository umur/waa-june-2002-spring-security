package com.cs545waa.lab06.security;

import com.cs545waa.lab06.repository.UaaRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AwesomeUserDetailsService implements UserDetailsService {

    private final UaaRepo repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user=repository.findUsersByEmail(username);
        var userDetails=new AwesomeUserDetails(user);
        return userDetails;
    }
}
