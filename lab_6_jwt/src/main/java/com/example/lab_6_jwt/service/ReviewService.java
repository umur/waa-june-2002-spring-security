package com.example.lab_6_jwt.service;

import com.example.lab_6_jwt.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAll();
    ReviewDto findById(Long id);
    void delete(Long id);
    ReviewDto save(ReviewDto review);
    List<ReviewDto> findAllReviewByProductId(Long id);
}
