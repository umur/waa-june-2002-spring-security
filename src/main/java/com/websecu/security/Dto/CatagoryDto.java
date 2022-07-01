package com.websecu.security.Dto;


import com.websecu.security.Domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryDto {
    private int id;
    private String name;

    private List<Product> products;
}
