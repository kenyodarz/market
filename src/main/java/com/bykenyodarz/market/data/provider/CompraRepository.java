package com.bykenyodarz.market.data.provider;

import com.bykenyodarz.market.data.api.CompraServiceAPI;
import com.bykenyodarz.market.data.models.Compra;
import com.bykenyodarz.market.data.repository.CompraJpaRepository;
import com.bykenyodarz.market.generated.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CompraRepository extends GenericServiceImpl<Compra, Integer> implements CompraServiceAPI {

    private final CompraJpaRepository repository;


    public CompraRepository(CompraJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<Compra, Integer> getRepository() {
        return this.repository;
    }
}
