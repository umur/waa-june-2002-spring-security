package com.miu.project6.security;

<<<<<<< HEAD:project6/src/main/java/com/miu/project6/security/AwesomeUserDetails.java
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.miu.project6.entity.Role;
import com.miu.project6.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AwesomeUserDetails implements UserDetails {

    private final String email;
=======
public class AuthUser implements UserDetails {
    private String userName;
>>>>>>> cad4705f720c5dfb468a9d45c84ea88ee840c166:project6/src/main/java/com/miu/project6/security/AuthUser.java

    @JsonIgnore
    private final String password;

    private final List<Role> roles;

    private User user;

    public AuthUser(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.roles = user.getRole();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
