package edu.miu.spring_security.dto;


import edu.miu.spring_security.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {

    private int id;
    private String name;
    private List<Product> products;
}
