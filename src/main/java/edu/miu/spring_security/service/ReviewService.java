package edu.miu.spring_security.service;

import edu.miu.spring_security.dto.ReviewDto;
import edu.miu.spring_security.entity.Review;

import java.util.List;

public interface ReviewService {
    void save(ReviewDto review);

    public void updateReview(ReviewDto review, Integer id);
    void delete(int id);

    Review getById(int id);

    List<ReviewDto> getAll();
}
