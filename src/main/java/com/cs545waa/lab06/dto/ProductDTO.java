package com.cs545waa.lab06.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private int rating;

    @JsonBackReference(value = "categoryProducts")
    private CategoryDTO category;

    @JsonBackReference(value = "userProducts")
    private AppUserDTO appUser;
    //@JsonIgnore
    @JsonManagedReference(value = "productReviews")
    private List<ReviewDTO> reviews;
}
