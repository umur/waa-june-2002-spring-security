package com.cs545waa.lab06.controller;

import com.cs545waa.lab06.dto.ReviewDTO;
import com.cs545waa.lab06.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService service;
    @GetMapping
    public List<ReviewDTO> read(){
        return service.readAll();
    }
    @PostMapping
    public void create(@RequestBody ReviewDTO dto){
        service.create(dto);
    }
    @PatchMapping
    public void update(@RequestBody ReviewDTO dto){
        service.update(dto);
    }
    @DeleteMapping
    public void delete(@RequestParam int id){
        service.delete(id);
    }
    @GetMapping("/filterByProduct")
    public List<ReviewDTO> readByCateAndPrice(@RequestParam int product){
        return service.findReviewsByProduct(product);
    }
}
