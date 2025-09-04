package com.example.demo.repository.mappers.product;

import com.example.demo.domain.entity.Product;
import com.example.demo.web.dto.product.ProductDto;


public interface ProductMapper{
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}
