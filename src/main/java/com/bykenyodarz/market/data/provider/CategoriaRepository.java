package com.bykenyodarz.market.data.provider;

import com.bykenyodarz.market.data.api.CaterogiaServiceAPI;
import com.bykenyodarz.market.data.models.Categoria;
import com.bykenyodarz.market.data.repository.CategoriaJpaRepository;
import com.bykenyodarz.market.generated.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository extends GenericServiceImpl<Categoria, Integer> implements CaterogiaServiceAPI {

    private final CategoriaJpaRepository repository;

    public CategoriaRepository(CategoriaJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<Categoria, Integer> getRepository() {
        return this.repository;
    }
}
