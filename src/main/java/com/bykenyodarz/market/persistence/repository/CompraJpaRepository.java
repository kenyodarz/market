package com.bykenyodarz.market.persistence.repository;

import com.bykenyodarz.market.persistence.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompraJpaRepository extends JpaRepository<Compra, Integer> {
}
