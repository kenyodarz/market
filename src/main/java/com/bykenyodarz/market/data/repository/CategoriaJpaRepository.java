package com.bykenyodarz.market.data.repository;

import com.bykenyodarz.market.data.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoriaJpaRepository extends JpaRepository<Categoria, Integer> {
}
