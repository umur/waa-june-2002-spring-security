package com.waa.lab5.service.impl;

import com.waa.lab5.entity.Product;
import com.waa.lab5.repo.ProductRepository;
import com.waa.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findProductByPriceGreaterThan(Double minPrice) {
        return productRepository.findProductByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findProductByPriceLessThanAndCategoryName(Double maxPrice, String categoryName) {
        return productRepository.findProductByPriceLessThanAndCategoryName(maxPrice, categoryName);
    }

    @Override
    public List<Product> findProductByNameContaining(String keyword) {
        return productRepository.findProductByNameContaining(keyword);
    }

    @Override
    public List<Product> findProductByUserId(Long userId) {
        return productRepository.findProductByUserId(userId);
    }
}
