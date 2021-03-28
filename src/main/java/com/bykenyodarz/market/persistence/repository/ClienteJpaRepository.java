package com.bykenyodarz.market.persistence.repository;

import com.bykenyodarz.market.persistence.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteJpaRepository extends JpaRepository<Cliente, String> {
}
