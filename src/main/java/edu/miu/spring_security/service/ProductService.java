package edu.miu.spring_security.service;


import edu.miu.spring_security.dto.ProductDto;
import edu.miu.spring_security.entity.Product;

import java.util.List;

public interface ProductService {

    void save(ProductDto p);

    public void updateProduct(ProductDto product, Integer id);

    void delete(int id);

    Product getById(int id);

    List<ProductDto> getAll();
}
