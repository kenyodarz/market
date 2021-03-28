package com.bykenyodarz.market.persistence.repository;

import com.bykenyodarz.market.persistence.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CompraJpaRepository extends JpaRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
