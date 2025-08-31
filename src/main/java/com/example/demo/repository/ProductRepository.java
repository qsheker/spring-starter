package com.example.demo.repository;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(Category category);

    List<Product> findByPriceBetween(BigDecimal price, BigDecimal priceBefore);

    List<Product> findByStockGreaterThan(Integer stockIsGreaterThan);

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findByCategoryAndPriceBetweenAndStockGreaterThan(Category category, BigDecimal priceAfter, BigDecimal priceBefore, Integer stockIsGreaterThan);
}
