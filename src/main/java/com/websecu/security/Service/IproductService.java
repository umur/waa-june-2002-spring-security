package com.websecu.security.Service;


import com.websecu.security.Dto.ProductDto;

import java.util.List;

public interface IproductService {
    public List<ProductDto> findAll();
    public ProductDto  findById(int id);
    public ProductDto add(ProductDto p);
    public String deleteById(int id);
    public ProductDto update(int id,ProductDto p);
    public List<ProductDto> findAllByPriceGreaterThan(Long minPrice);
    public List<ProductDto> findByCatagoryAndPriceLessThan(String categoryName, Double maxPrice);
    public List<ProductDto> findAllByNameContains(String keyword);
}
