package com.bykenyodarz.market.persistence.providers;

import com.bykenyodarz.market.persistence.repository.CompraJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CompraRepository {

    private final CompraJpaRepository repository;


    public CompraRepository(CompraJpaRepository repository) {
        this.repository = repository;
    }

}
