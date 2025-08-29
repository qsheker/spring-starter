package com.example.demo.services.impl;

import com.example.demo.domain.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.services.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByName(String name) {
        Category category = categoryRepository.findByName(name);
        if(category==null){
            throw new EntityNotFoundException("Category not found with name: "+name);
        }
        return category;
    }

    @Override
    public Category findCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Category not found with id: "+id));
        return category;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = findCategoryById(id);
        categoryRepository.delete(category);
    }
}
