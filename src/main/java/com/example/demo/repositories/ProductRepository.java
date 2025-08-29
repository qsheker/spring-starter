package com.example.demo.repositories;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(Category category);

    List<Product> findByPriceBetween(BigDecimal price, BigDecimal priceBefore);

    List<Product> findByStockGreaterThan(Integer stockIsGreaterThan);

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findByCategoryAndPriceBetweenAndStockGreaterThan(Category category, BigDecimal priceAfter, BigDecimal priceBefore, Integer stockIsGreaterThan);



}
