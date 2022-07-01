package com.websecu.security.Domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Long price;
    private String rating;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Catagory catagory;
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<Review> reviews;
}
