package edu.miu.spring_security.controller;

import edu.miu.spring_security.dto.ReviewDto;
import edu.miu.spring_security.entity.Review;
import edu.miu.spring_security.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/reviews/")
    public void save(@RequestBody ReviewDto p) {
        reviewService.save(p);
    }

    @GetMapping("/reviews/")
    public List<ReviewDto> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/reviews/{id}")
    public Review getById(@PathVariable int id) {
        return reviewService.getById(id);
    }

    @DeleteMapping("/reviews/{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }

    @PutMapping("/reviews/{id}")
    public void update(@PathVariable("id") int id, @RequestBody ReviewDto review) {
        reviewService.updateReview(review, id);
    }
}
