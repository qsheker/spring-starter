package com.example.demo.services;

import com.example.demo.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findByName(String name);

    Category findCategoryById(Long id);

    List<Category> findAll();

    Category save(Category category);

    void deleteCategoryById(Long id);
}
