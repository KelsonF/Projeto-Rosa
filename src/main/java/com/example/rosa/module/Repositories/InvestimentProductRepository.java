package com.example.rosa.module.Repositories;

import com.example.rosa.module.Entities.InvestimentProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestimentProductRepository extends JpaRepository<InvestimentProduct, String> {
}
