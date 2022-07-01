package com.websecu.security.Service;


import com.websecu.security.Dto.ReviewDto;

import java.util.List;

public interface IReviewService {
    public List<ReviewDto> findAll();
    public ReviewDto  findById(int id);
    public ReviewDto add(ReviewDto r);
    public String deleteById(int id);
    public ReviewDto update(int id,ReviewDto r);
}
