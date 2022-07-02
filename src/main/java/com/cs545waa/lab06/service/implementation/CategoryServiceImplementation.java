package com.cs545waa.lab06.service.implementation;

import com.cs545waa.lab06.dto.CategoryDTO;
import com.cs545waa.lab06.entity.Category;
import com.cs545waa.lab06.repository.CategoryRepo;
import com.cs545waa.lab06.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Data
@Transactional
public class CategoryServiceImplementation implements CategoryService {
    private final ModelMapper mapper;
    private final CategoryRepo repository;
    @Override
    public void create(CategoryDTO dto) {
        repository.save(mapper.map(dto, Category.class));
    }

    @Override
    public void update(CategoryDTO dto) {
        repository.save(mapper.map(dto, Category.class));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public CategoryDTO read(int id) {
        return mapper.map(repository.findById(id).get(),CategoryDTO.class);
    }

    public List<CategoryDTO> readAll() {
        List<CategoryDTO> categories=new ArrayList<>();
        repository.findAll().forEach(category -> categories.add( mapper.map(category,CategoryDTO.class)));
        return categories;
    }
}
