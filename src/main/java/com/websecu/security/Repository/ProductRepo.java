package com.websecu.security.Repository;


import com.websecu.security.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    List<Product> findAllByPriceGreaterThan(Long minPrice);

    List<Product> findByCatagoryAndPriceLessThan(String categoryName, Double maxPrice);

    List<Product> findAllByNameContains( String name);
}
