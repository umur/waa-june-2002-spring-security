package edu.miu.spring_security.service.impl;

import edu.miu.spring_security.dto.ProductDto;
import edu.miu.spring_security.entity.Product;
import edu.miu.spring_security.repo.ProductRepo;
import edu.miu.spring_security.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private ModelMapper mapper;

    @Override
    public void save(ProductDto dto) {
        productRepo.save(dtoToEntity(dto));
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<ProductDto> getAll() {
        var products = productRepo.findAll();
        var result = new ArrayList<ProductDto>();

        for(Product product: products){
            ProductDto dto = new ProductDto();
            var productDto = toDto(product);
            result.add(productDto);
        }
        return result;
    }

    public void updateProduct(ProductDto productDto, Integer id){
        Product pr = getById(id);
        pr.setName(productDto.getName());
        pr.setPrice(productDto.getPrice());
        pr.setRating(productDto.getRating());
        pr.setReviews(productDto.getReviews());

        productRepo.save(pr);
    }

    private ProductDto toDto(Product product){
        ProductDto dto = mapper.map(product, ProductDto.class);
        return dto;
    }
    public Product dtoToEntity(ProductDto productDto){
        Product product = mapper.map(productDto, Product.class);
        return product;
    }
}
