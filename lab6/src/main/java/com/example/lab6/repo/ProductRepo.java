package com.example.lab6.repo;

import org.springframework.data.repository.CrudRepository;
import com.sudip.lab5.entity.Product;

public interface ProductRepo extends CrudRepository<Product,Integer> {
}
