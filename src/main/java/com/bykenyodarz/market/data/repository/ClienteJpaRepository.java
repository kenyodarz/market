package com.bykenyodarz.market.data.repository;

import com.bykenyodarz.market.data.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ClienteJpaRepository extends JpaRepository<Cliente, String> {
}
