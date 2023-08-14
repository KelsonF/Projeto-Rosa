package com.example.rosa.module.Entities;

import com.example.rosa.module.Enums.InvestimentProductStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "InvestmentProduct")
public class InvestimentProduct {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    @Enumerated(EnumType.STRING)
    private InvestimentProductStatus status;
    private String destination;
    private String profitabilityRate;
    private int term;
    private double administrationTax;
}
