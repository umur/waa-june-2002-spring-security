package edu.miu.springsecurity.service;

import edu.miu.springsecurity.domain.Product;
import edu.miu.springsecurity.dto.ProductDtoResponse;

import java.util.List;

public interface ProductService {
  void save(Product p);
  void delete(int id);
  Product getById(int id);
  List<ProductDtoResponse> getAll();
}
