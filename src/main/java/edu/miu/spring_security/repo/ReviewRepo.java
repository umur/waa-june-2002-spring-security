package edu.miu.spring_security.repo;

import edu.miu.spring_security.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {

    List<Review> findAll();
}
