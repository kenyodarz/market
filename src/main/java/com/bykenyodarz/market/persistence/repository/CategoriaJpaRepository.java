package com.bykenyodarz.market.persistence.repository;

import com.bykenyodarz.market.persistence.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaJpaRepository extends JpaRepository<Categoria, Integer> {
}
