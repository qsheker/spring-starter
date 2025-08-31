package com.example.demo.repository.mappers.product;

import com.example.demo.domain.entity.Product;
import com.example.demo.repository.mappers.Mapper;
import com.example.demo.repository.mappers.category.CategoryMapper;
import com.example.demo.web.dto.product.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, ProductDto> {
    private final CategoryMapper categoryMapper;

    public ProductMapper(CategoryMapper categoryMapper){
        this.categoryMapper =categoryMapper;
    }



    @Override
    public ProductDto mapTo(Product clazz) {
        return new ProductDto(
                clazz.getId(),
                clazz.getName(),
                clazz.getDescription(),
                clazz.getPrice(),
                categoryMapper.mapTo(clazz.getCategory())
        );
    }
}
