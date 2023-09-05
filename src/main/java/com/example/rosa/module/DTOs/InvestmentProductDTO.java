package com.example.rosa.module.DTOs;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvestmentProductDTO {

    @NotNull
    @Min(3)
    @Max(100)
    private String name;

    @NotBlank
    @Max(200)
    private String destination;

    @NotNull
    @Positive
    private double profitabilityRate;

    @NotNull
    @Positive
    private int term;

    @PositiveOrZero
    @Max(1)
    @NotNull
    private double administrationTax;

    private Integer expired;
}
