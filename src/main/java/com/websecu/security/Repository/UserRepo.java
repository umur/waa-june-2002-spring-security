package com.websecu.security.Repository;


import com.websecu.security.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {
    User findByEmail(String username);
}
