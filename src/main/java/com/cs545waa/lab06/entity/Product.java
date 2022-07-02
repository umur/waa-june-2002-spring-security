package com.cs545waa.lab06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity //JPA requirement
@Data   //getter and setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private int rating;

    @ManyToOne
    private Category category;

    @ManyToOne
    private AppUser appUser;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
