package edu.miu.waa_lab6_a.repository;

import edu.miu.waa_lab6_a.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
}
