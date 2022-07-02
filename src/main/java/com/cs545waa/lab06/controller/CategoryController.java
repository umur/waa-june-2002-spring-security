package com.cs545waa.lab06.controller;

import com.cs545waa.lab06.dto.CategoryDTO;
import com.cs545waa.lab06.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService service;
    @GetMapping
    public List<CategoryDTO> read(){
        return service.readAll();
    }
    @PostMapping
    public void create(@RequestBody CategoryDTO dto){
        service.create(dto);
    }
    @PatchMapping
    public void update(@RequestBody CategoryDTO dto){
        service.update(dto);
    }
    @DeleteMapping
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
