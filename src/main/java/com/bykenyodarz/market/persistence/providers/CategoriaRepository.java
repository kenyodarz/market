package com.bykenyodarz.market.persistence.providers;

import com.bykenyodarz.market.persistence.repository.CategoriaJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository {

    private final CategoriaJpaRepository repository;

    public CategoriaRepository(CategoriaJpaRepository repository) {
        this.repository = repository;
    }

}
