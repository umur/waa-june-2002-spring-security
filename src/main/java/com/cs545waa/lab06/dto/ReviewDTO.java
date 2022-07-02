package com.cs545waa.lab06.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private int id;
    private String comment;
    @JsonBackReference(value = "userReviews")
    private AppUserDTO appUser;
    @JsonBackReference(value = "productReviews")
    private ProductDTO product;
}
