package com.websecu.security.Service.Impl;


import com.websecu.security.Domain.Product;
import com.websecu.security.Dto.ProductDto;
import com.websecu.security.Repository.ProductRepo;
import com.websecu.security.Service.IproductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
@Service
@Transactional

public class ProductService implements IproductService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepo productRepo;

    public ProductService(ModelMapper modelMapper, ProductRepo productRepo) {
        this.modelMapper = modelMapper;
        this.productRepo = productRepo;
    }
   // @ExecutionTime
    @Override
    public List<ProductDto> findAll() {
        var products= productRepo.findAll();
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
       return modelMapper.map(products,listType);

    }

    @Override
    public ProductDto findById(int id) {
        var p=productRepo.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("ProductDto with id %s does not exits",id)));;
       ProductDto pdto=modelMapper.map(p,ProductDto.class);
        return pdto;
    }

    @Override
    public ProductDto add(ProductDto p) {
        var product=modelMapper.map(p, Product.class);
        productRepo.save(product);
        return modelMapper.map(product,ProductDto.class);

    }

    @Override
    public String deleteById(int id) {
        var product=productRepo.findById(id).orElseThrow();
        productRepo.delete(product);

        return "deleted";
    }

    @Override
    public ProductDto update(int id, ProductDto p) {

        var product=productRepo.findById(id).orElseThrow();
        var p1=modelMapper.map(p,Product.class);
        productRepo.save(p1);
        return modelMapper.map(p1,ProductDto.class);

    }
    @Override
    public List<ProductDto> findAllByPriceGreaterThan(Long minPrice) {
        var products = productRepo.findAllByPriceGreaterThan(minPrice);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }

    @Override
    public List<ProductDto> findByCatagoryAndPriceLessThan(String categoryName, Double maxPrice) {
        var products = productRepo.findByCatagoryAndPriceLessThan(categoryName,maxPrice);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }

    @Override
    public List<ProductDto> findAllByNameContains(String keyword) {
        var products = productRepo.findAllByNameContains(keyword);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }
}
