package com.waa.lab5.service.impl;

import com.waa.lab5.entity.Review;
import com.waa.lab5.repo.ReviewRepository;
import com.waa.lab5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review findReviewByProductId(Long productId) {
        return reviewRepository.findReviewByProductId(productId);
    }
}
