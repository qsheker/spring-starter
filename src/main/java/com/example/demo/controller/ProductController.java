package com.example.demo.controller;

import com.example.demo.domain.entity.Product;
import com.example.demo.web.dto.mappers.product.ProductMapper;
import com.example.demo.web.dto.mappers.product.ProductShortMapper;
import com.example.demo.services.ProductService;
import com.example.demo.web.dto.product.ProductDto;
import com.example.demo.web.dto.product.ProductShortDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductShortMapper productShortMapper;

    public ProductController(ProductService productService, ProductMapper productMapper, ProductShortMapper productShortMapper){
        this.productService = productService;
        this.productMapper = productMapper;
        this.productShortMapper = productShortMapper;
    }

    @PostMapping
    public ProductShortDto create(@Valid @RequestBody ProductDto productDto){
        Product entity = productMapper.toEntity(productDto);
        Product product = productService.save(entity);
        return productShortMapper.toDto(product);
    }
    @GetMapping
    public List<ProductShortDto> getAll(){
        return productService.findAll().stream()
                .map(product -> productShortMapper.toDto(product)).toList();
    }
    @GetMapping("/{id}")
    public ProductShortDto getProductById(@PathVariable("id") Long id){
        return productShortMapper.toDto(productService.findById(id));
    }
    @PutMapping("/{id}")
    public ProductShortDto update(@PathVariable("id") Long id,@Valid @RequestBody ProductDto productDto){
        Product product = productMapper.toEntity(productDto);
        product.setId(id);
        return productShortMapper.toDto(productService.save(product));
    }
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
    }


}
