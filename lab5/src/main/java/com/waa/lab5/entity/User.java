package com.waa.lab5.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();
}
