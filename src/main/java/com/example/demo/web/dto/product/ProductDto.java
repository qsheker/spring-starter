package com.example.demo.web.dto.product;

import com.example.demo.web.dto.category.CategoryDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    @NotNull(message = "Id must not be null!")
    private Long id;

    @NotBlank(message = "Name cannot be blank!")
    private String name;

    @NotBlank(message = "Description can not be null!")
    private String description;

    @NotNull(message = "Price can not be null!")
    @Min(1)
    @Positive
    private BigDecimal price;

    @NotNull(message = "Category can not be null!")
    private CategoryDto category;
}
