package com.miu.project6.service;

public interface ProductService {
    void save(Product p);
    void delete(int id);
    Product getById(int id);
    List<ProductDtoResponse> getAll();
}
