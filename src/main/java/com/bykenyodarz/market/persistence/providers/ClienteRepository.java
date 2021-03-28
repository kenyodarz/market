package com.bykenyodarz.market.persistence.providers;

import com.bykenyodarz.market.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

    private final ClienteJpaRepository repository;

    public ClienteRepository(ClienteJpaRepository repository) {
        this.repository = repository;
    }

}
