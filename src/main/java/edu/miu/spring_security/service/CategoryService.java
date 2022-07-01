package edu.miu.spring_security.service;

import edu.miu.spring_security.dto.CategoryDto;
import edu.miu.spring_security.entity.Category;

import java.util.List;

public interface CategoryService {

    void save(CategoryDto category);

    public void updateCategory(CategoryDto category, Integer id);
    void delete(int id);

    Category getById(int id);

    List<CategoryDto> getAll();
}
