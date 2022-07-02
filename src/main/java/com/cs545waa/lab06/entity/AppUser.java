package com.cs545waa.lab06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToOne(mappedBy = "appUser", fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(mappedBy = "appUser", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "appUser", fetch = FetchType.LAZY)
    private List<Product> products;
}
