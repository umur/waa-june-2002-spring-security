package edu.miu.springsecurity.controller;

import edu.miu.springsecurity.annotation.ExecutionTime;

import edu.miu.springsecurity.domain.Product;
import edu.miu.springsecurity.domain.User;
import edu.miu.springsecurity.dto.ProductDtoResponse;
import edu.miu.springsecurity.security.AuthUser;
import edu.miu.springsecurity.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
  private final ProductService productService;

  @PostMapping
  public ResponseEntity<Product> save(@RequestBody Product p) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Object principal = authentication.getPrincipal();
    if (principal instanceof AuthUser) {
      User user = ((AuthUser) principal).getUser();
      p.setUser(user);
      productService.save(p);
    }

    return ResponseEntity.ok(p);
  }

  @ExecutionTime
  @GetMapping
  public ResponseEntity<List<ProductDtoResponse>> getAll() {
    var products =  productService.getAll();
    return ResponseEntity.ok().body(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable int id) {
    var product = productService.getById(id);
    return ResponseEntity.ok(product);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    productService.delete(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable int id) {
    // call service to update product
  }
}
