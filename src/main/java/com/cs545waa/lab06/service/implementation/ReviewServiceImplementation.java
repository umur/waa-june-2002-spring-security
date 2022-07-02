package com.cs545waa.lab06.service.implementation;

import com.cs545waa.lab06.dto.ProductDTO;
import com.cs545waa.lab06.dto.ReviewDTO;
import com.cs545waa.lab06.entity.Product;
import com.cs545waa.lab06.entity.Review;
import com.cs545waa.lab06.repository.ReviewRepo;
import com.cs545waa.lab06.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@Transactional
public class ReviewServiceImplementation implements ReviewService {
    private final ModelMapper mapper;
    private final ReviewRepo repository;
    @Override
    public void create(ReviewDTO dto) {
        repository.save(mapper.map(dto, Review.class));
    }

    @Override
    public void update(ReviewDTO dto) {
        repository.save(mapper.map(dto, Review.class));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public ReviewDTO read(int id) {
        return mapper.map(repository.findById(id).get(),ReviewDTO.class);
    }

    @Override
    public List<ReviewDTO> readAll() {
        List<ReviewDTO> products=new ArrayList<>();
        repository.findAll().forEach(product -> products.add( mapper.map(product,ReviewDTO.class)));
        return products;
    }
    @Override
    public List<ReviewDTO> findReviewsByProduct(int product) {
        ProductDTO dto=new ProductDTO();
        dto.setId(product);
        return repository.findReviewsByProduct(mapper.map(dto, Product.class))
                .stream()
                .map(review -> mapper.map(review,ReviewDTO.class))
                .toList();
    }
}
