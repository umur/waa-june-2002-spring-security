package com.example.lab_6_jwt.repository;


import com.example.lab_6_jwt.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByProductId(Long id);

}
