package com.bykenyodarz.market.data.provider;

import com.bykenyodarz.market.data.api.ClienteServiceAPI;
import com.bykenyodarz.market.data.models.Cliente;
import com.bykenyodarz.market.data.repository.ClienteJpaRepository;
import com.bykenyodarz.market.generated.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository extends GenericServiceImpl<Cliente, String> implements ClienteServiceAPI {

    private final ClienteJpaRepository repository;

    public ClienteRepository(ClienteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<Cliente, String> getRepository() {
        return repository;
    }
}
