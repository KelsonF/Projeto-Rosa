package com.example.rosa.module.Entities;

import com.example.rosa.module.Enums.InvestimentProductStatus;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "investment_product")
public class InvestimentProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private InvestimentProductStatus status;

    private String destination;
    private double profitabilityRate;
    private int term;
    private double administrationTax;
    private Integer expired;
}
