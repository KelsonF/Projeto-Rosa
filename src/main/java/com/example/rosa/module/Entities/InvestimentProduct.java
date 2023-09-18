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

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private InvestimentProductStatus status;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private double profitabilityRate;

    @Column(nullable = false)
    private int term;

    @Column(nullable = false)
    private double administrationTax;

    @Column(nullable = false)
    private Integer expired;
}
