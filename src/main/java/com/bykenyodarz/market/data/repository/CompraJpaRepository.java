package com.bykenyodarz.market.data.repository;

import com.bykenyodarz.market.data.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CompraJpaRepository extends JpaRepository<Compra, Integer> {
}
