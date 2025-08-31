package com.example.demo.repository.mappers.category;

import com.example.demo.domain.entity.Category;
import com.example.demo.repository.mappers.Mapper;
import com.example.demo.web.dto.category.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<Category, CategoryDto> {
    @Override
    public CategoryDto mapTo(Category clazz) {
        return new CategoryDto(
                clazz.getId(),
                clazz.getName()
        );
    }
}
