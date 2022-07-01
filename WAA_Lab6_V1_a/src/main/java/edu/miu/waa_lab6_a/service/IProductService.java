package edu.miu.waa_lab6_a.service;

import edu.miu.waa_lab6_a.model.Product;

import java.util.List;

public interface IProductService {
    void save(Product p);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();
}
