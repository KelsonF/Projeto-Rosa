package com.example.rosa.module.Entities;

import com.example.rosa.module.Enums.InvestimentProductStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import lombok.*;
import java.util.UUID;

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
}
