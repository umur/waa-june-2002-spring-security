package com.websecu.security.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catagory {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(mappedBy = "catagory",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products;
}
