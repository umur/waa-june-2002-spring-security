package com.websecu.security.Controller;


import com.websecu.security.Dto.ReviewDto;
import com.websecu.security.Service.Impl.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;



    @GetMapping("/reviews")
    public List<ReviewDto> findAll(){
       return reviewService.findAll();
    }
    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id){
        return reviewService.findById(id);
    }
    @PostMapping("/review")
    public ReviewDto add(@RequestBody ReviewDto r){
        return reviewService.add(r);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return reviewService.deleteById(id);
    }
    @PutMapping("/{id}")
    public ReviewDto update(@PathVariable int id, ReviewDto r){
        return reviewService.update(id,r);
    }
    @GetMapping("/product/{id}")
    public List<ReviewDto> findAllByProductId(@PathVariable Long id){
        return reviewService.findAllByProductId(id);
    }

}
