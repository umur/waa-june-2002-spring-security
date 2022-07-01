package com.example.spring_jwt.repository;

import com.example.spring_jwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
