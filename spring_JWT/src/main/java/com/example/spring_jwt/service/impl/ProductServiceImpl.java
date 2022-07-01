package com.example.spring_jwt.service.impl;

import com.example.spring_jwt.dto.ProductDtoResponse;
import com.example.spring_jwt.entity.Product;
import com.example.spring_jwt.repository.ProductRepo;
import com.example.spring_jwt.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepo productRepo;
  private final ModelMapper modelMapper;

  @Override
  public void save(Product p) {
    productRepo.save(p);
  }

  @Override
  public void delete(int id) {
    productRepo.deleteById(id);
  }

  @Override
  public Product getById(int id) {
    return productRepo.findById(id).get();
  }


  @Override
  public List<ProductDtoResponse> getAll() {
    var products = productRepo.findAll();
    Type listType = new TypeToken<List<ProductDtoResponse>>(){}.getType();
    return modelMapper.map(products,listType);
  }
}
