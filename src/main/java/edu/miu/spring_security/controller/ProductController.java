package edu.miu.spring_security.controller;


import edu.miu.spring_security.dto.ProductDto;
import edu.miu.spring_security.entity.Product;
import edu.miu.spring_security.entity.Review;
import edu.miu.spring_security.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products/")
    public void save(@RequestBody ProductDto p) {
        productService.save(p);
    }

    @GetMapping("/products/")
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/products/{id}")
    public void update(@PathVariable("id") int id, @RequestBody ProductDto product) {
        productService.updateProduct(product, id);
    }

    @GetMapping("/products/{id}/reviews")
    public List<Review> getReviewsByProductId(@PathVariable int id) {
        return productService.getById(id).getReviews();
    }


}
