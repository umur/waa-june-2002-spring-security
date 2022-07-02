package com.cs545waa.lab06.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int id;
    private String name;

    @JsonManagedReference(value = "categoryProducts")
    private List<ProductDTO> products;
}
