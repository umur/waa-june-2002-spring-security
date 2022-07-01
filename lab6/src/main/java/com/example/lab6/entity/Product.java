package com.sudip.lab5.entity;

import com.example.lab6.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    private String productName;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
//  @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//  @OneToMany
//  @JoinColumn(name = "product_id")
//  @JsonManagedReference
    private List<com.sudip.lab5.entity.Review> reviews;

    //  @ManyToMany(mappedBy = "products")
    @ManyToMany
    @JoinTable(name = "categories_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<com.sudip.lab5.entity.Category> categories;
}
