package com.waa.lab5.service;

import com.waa.lab5.entity.Review;

public interface ReviewService {

    Review findReviewByProductId(Long productId);

}
