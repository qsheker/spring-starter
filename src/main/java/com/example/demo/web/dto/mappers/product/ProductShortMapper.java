package com.example.demo.repository.mappers.product;

import com.example.demo.domain.entity.Product;
import com.example.demo.web.dto.product.ProductShortDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductShortMapper {
    ProductShortDto toDto(Product product);

    Product toEntity(ProductShortDto productDto);
}
