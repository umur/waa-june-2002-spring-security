package com.cs545waa.lab06.service;

import com.cs545waa.lab06.dto.ReviewDTO;

import java.util.List;

public interface ReviewService{
    public void create(ReviewDTO dto);
    public void update(ReviewDTO dto);
    public void delete(int id);
    public ReviewDTO read(int id);
    public List<ReviewDTO> readAll();
    public List<ReviewDTO> findReviewsByProduct(int product);
}
