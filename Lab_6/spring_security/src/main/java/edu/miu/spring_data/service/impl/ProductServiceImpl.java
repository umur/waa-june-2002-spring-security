package edu.miu.spring_data.service.impl;

import edu.miu.spring_data.dto.ProductDto;

import edu.miu.spring_data.entity.Category;
import edu.miu.spring_data.entity.Product;

import edu.miu.spring_data.entity.Review;

import edu.miu.spring_data.repository.ProductRepository;
import edu.miu.spring_data.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelmapper = new ModelMapper();

    @PersistenceContext
    EntityManager em;

    //private final ListMapper<Product , ProductDto> listMapperProductToDto;   // from helper package

    @Override
    public List<ProductDto> findAll() {

        var products = productRepository.findAll();

        return null;
//        return (List<ProductDto>) listMapperProductToDto.mapList(products , new ProductDto());
    }

    @Override
    public ProductDto getProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null)
        {
            ProductDto productDto = modelmapper.map(product, ProductDto.class);
            return productDto;
        }

        return null;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = modelmapper.map(productDto , Product.class);
        Product p = productRepository.save(product);
        ProductDto pp = modelmapper.map(p , ProductDto.class);
        return pp;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, int id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null)
        {
            Product p = modelmapper.map(productDto , Product.class);
            Product pp = productRepository.save(p);
            ProductDto pdto = modelmapper.map(pp , ProductDto.class);
            return pdto;
        }
        return null;
    }


    @Override
    public void deleteProduct(int id) {

        Product product = productRepository.findById(id).orElse(null);
        if(product != null)
        {
            productRepository.delete(product);
        }

    }

    @Override
    public List<Product> findByPriceGreaterThan(Double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findByCategoryAndPriceLessThan(Integer category_id , Double maxPrice) {
        return productRepository.findByCategoryIdAndPriceLessThan(category_id  , maxPrice);
    }

    @Override
    public List<Product> findByNameContains(String keyword) {
        return productRepository.findByNameContains(keyword);
    }

    @Override
    public List<Review> findAllReviewsOfProduct(Integer productId) {
        return productRepository.findAllReviewsOfProduct(productId);
    }
}
