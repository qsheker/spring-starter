package com.example.demo.controller;

import com.example.demo.domain.entity.Category;
import com.example.demo.web.dto.mappers.category.CategoryMapper;
import com.example.demo.services.CategoryService;
import com.example.demo.web.dto.category.CategoryDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper){
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("{name}")
    public CategoryDto getByName(@PathVariable("name") String name){
        return categoryMapper.toDto(categoryService.findByName(name));
    }

    @GetMapping("{id}")
    public CategoryDto getCategoryById(@PathVariable("id") Long id){
        return categoryMapper.toDto(categoryService.findCategoryById(id));
    }

    @GetMapping
    public List<CategoryDto> getAll(){
        return categoryService.findAll()
                .stream()
                .map(category -> categoryMapper.toDto(category))
                .toList();
    }
    @PostMapping
    public CategoryDto create(@Valid @RequestBody CategoryDto categoryDto){
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryService.save(category));
    }

    @DeleteMapping("{id}")
    public void deleteCategoryById(@PathVariable("id") Long id){
        categoryService.deleteCategoryById(id);
    }

}
