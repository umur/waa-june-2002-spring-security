package com.waa.lab5.controller;

import com.waa.lab5.aspect.annotation.ExecutionTime;
import com.waa.lab5.entity.Review;
import com.waa.lab5.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/search")
    @ExecutionTime
    public Review findByProductId(@RequestParam Long productId) {
        return reviewService.findReviewByProductId(productId);
    }
}
