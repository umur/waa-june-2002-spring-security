package com.cs545waa.lab06.service;

import com.cs545waa.lab06.dto.CategoryDTO;
import com.cs545waa.lab06.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public void create(ProductDTO dto);
    public void update(ProductDTO dto);
    public void delete(int id);
    public ProductDTO read(int id);
    public List<ProductDTO> readAll();
    public List<ProductDTO> findProductByPriceLessThan(double price);
    public List<ProductDTO> findProductsByCategoryAndPriceLessThan(CategoryDTO name, double price);
    public List<ProductDTO> findProductsByNameContains(String name);
    public List<ProductDTO> findProductsByAppUser(int appUser);
}
