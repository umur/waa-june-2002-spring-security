package com.springjwt.service;

import com.springjwt.models.Product;

import java.util.List;

public interface ProductService {
    void save(Product p);

    List<Product> findAll();
}
