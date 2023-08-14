package com.example.rosa.module.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvestmentProductDTO {
    private String name;
    private String destination;
    private String profitabilityRate;
    private int term;
    private double administrationTax;
}
