package com.example.spring_jwt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private int id;
    private String username;

    private String email;
    private String password;
    private String firstname;
    private String lastname;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
