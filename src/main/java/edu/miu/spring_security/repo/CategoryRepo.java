package edu.miu.spring_security.repo;

import edu.miu.spring_security.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {

    List<Category> findAll();
}
