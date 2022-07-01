package com.websecu.security.Dto;


import com.websecu.security.Domain.Catagory;
import com.websecu.security.Domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private Long price;
    private String rating;

    private Catagory catagory;
    private List<Review> reviews;


}
