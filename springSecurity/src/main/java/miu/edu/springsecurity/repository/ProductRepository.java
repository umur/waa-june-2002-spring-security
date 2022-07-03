package miu.edu.springsecurity.repository;

import miu.edu.springsecurity.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAllByPriceGreaterThan(Double minPrice);

    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);

    List<Product> findAllByNameContains(@Param("name") String name);

}
