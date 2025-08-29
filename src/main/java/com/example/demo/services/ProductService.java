package com.example.demo.services;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product findById(Long id);

    List<Product> findAll();

    Product save(Product product);

    void deleteProductById(Long id);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(Category category);

    List<Product> findByPriceBetween(BigDecimal price, BigDecimal priceBefore);

    List<Product> findByStockGreaterThan(Integer stockIsGreaterThan);

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findByCategoryAndPriceBetweenAndStockGreaterThan(Category category, BigDecimal priceAfter, BigDecimal priceBefore, Integer stockIsGreaterThan);

}
