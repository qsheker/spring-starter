package com.example.demo.web.dto.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CardRequestDto {
    @NotBlank(message = "Credit card number cannot be empty")
    @Pattern(
            regexp = "^[0-9]{16}$",
            message = "Credit card number must be exactly 16 digits"
    )
    private String creditNumber;

    @NotBlank(message = "CVV cannot be empty")
    @Pattern(
            regexp = "^[0-9]{3}$",
            message = "CVV must be 3 or 4 digits"
    )
    private String cvv;

    @NotBlank(message = "Expiration date cannot be empty")
    @Pattern(
            regexp = "^(0[1-9]|1[0-2])/(\\d{2})$",
            message = "Expiration date must be in format MM/YY"
    )
    private String date;
}
