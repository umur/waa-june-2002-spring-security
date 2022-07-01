package com.waa.lab5.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer rating;

    @ManyToOne
    @ToString.Exclude
    private Category category;

    @OneToOne
    private User user;

}
