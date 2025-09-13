package com.example.demo.repository.mappers.product;

import com.example.demo.domain.entity.Product;
import com.example.demo.web.dto.product.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper{
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}
