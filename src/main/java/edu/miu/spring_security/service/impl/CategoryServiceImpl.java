package edu.miu.spring_security.service.impl;

import edu.miu.spring_security.dto.CategoryDto;
import edu.miu.spring_security.entity.Category;
import edu.miu.spring_security.repo.CategoryRepo;
import edu.miu.spring_security.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepo;

    private ModelMapper mapper;

    @Override
    public void save(CategoryDto categoryDto) {
        categoryRepo.save(dtoToEntity(categoryDto));
    }

    @Override
    public void updateCategory(CategoryDto categoryDto, Integer id){
        Category category = getById(id);
        category.setName(categoryDto.getName());
        category.setProducts(categoryDto.getProducts());

        categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Category getById(int id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public List<CategoryDto> getAll() {
        var categorys = categoryRepo.findAll();
        var result = new ArrayList<CategoryDto>();

        for(Category category: categorys){
            CategoryDto dto = new CategoryDto();
            var categoryDto = toDto(category);
            result.add(categoryDto);
        }
        return result;
    }

    private CategoryDto toDto(Category category){
        CategoryDto dto = mapper.map(category, CategoryDto.class);
        return dto;
    }
    public Category dtoToEntity(CategoryDto categoryDto){
        Category category = mapper.map(categoryDto, Category.class);
        return category;
    }
}
