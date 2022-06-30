package com.example.lab_6_jwt.repository;


import com.example.lab_6_jwt.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository<Review, Long> {
    List<Review> findAllByProductId(Long id);

}
