package com.example.demo.repository.mappers.category;


import com.example.demo.web.dto.category.CategoryDto;
import com.example.demo.domain.entity.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper{
    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);
}
