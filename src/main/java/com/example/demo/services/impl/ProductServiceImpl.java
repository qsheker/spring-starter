package com.example.demo.services.impl;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Product findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Product not found with id: "+id));
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Product not found with id: "+id));
        productRepository.delete(product);
    }

    @Override
    public List<Product> findAllByOrderByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> findByCategoryAndPriceBetweenAndStockGreaterThan(Category category, BigDecimal priceAfter, BigDecimal priceBefore, Integer stockIsGreaterThan) {
        return productRepository.findByCategoryAndPriceBetweenAndStockGreaterThan(category, priceAfter, priceBefore, stockIsGreaterThan);
    }

    @Override
    public List<Product> findAllByOrderByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Product> findByStockGreaterThan(Integer stockIsGreaterThan) {
        return productRepository.findByStockGreaterThan(stockIsGreaterThan);
    }

    @Override
    public List<Product> findByPriceBetween(BigDecimal price, BigDecimal priceBefore) {
        return productRepository.findByPriceBetween(price, priceBefore);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        List<Product> products = productRepository.findProductsByNameContainingIgnoreCase(name);
        if(products.isEmpty()){
            throw new EntityNotFoundException("No products found with name containing: " + name);
        }
        return products;
    }
}
