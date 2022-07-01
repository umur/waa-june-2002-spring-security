package edu.miu.spring_security.dto;

import edu.miu.spring_security.entity.Category;
import edu.miu.spring_security.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    private int id;
    private String name;
    private float price;
    private double rating;
    private Category category;
    private List<Review> reviews;

}
