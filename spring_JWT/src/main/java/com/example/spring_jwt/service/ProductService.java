package com.example.spring_jwt.service;

import com.example.spring_jwt.dto.ProductDtoResponse;
import com.example.spring_jwt.entity.Product;

import java.util.List;

public interface ProductService {
  void save(Product p);
  void delete(int id);
  Product getById(int id);
  List<ProductDtoResponse> getAll();
}
