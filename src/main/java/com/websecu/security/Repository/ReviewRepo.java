package com.websecu.security.Repository;


import com.websecu.security.Domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReviewRepo extends JpaRepository<Review,Integer> {
    List<Review> findAllById(Long id);
}
