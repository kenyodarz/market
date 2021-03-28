package com.bykenyodarz.market.persistence.providers;

import com.bykenyodarz.market.domain.repositories.PurchaseRepository;
import com.bykenyodarz.market.domain.viewmodel.Purchase;
import com.bykenyodarz.market.persistence.mappers.PurchaseMapper;
import com.bykenyodarz.market.persistence.models.Compra;
import com.bykenyodarz.market.persistence.repository.CompraJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private final CompraJpaRepository repository;
    private final PurchaseMapper mapper;


    public CompraRepository(CompraJpaRepository repository, PurchaseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases(repository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return repository.findByIdCliente(clientId)
                .map(mapper::toPurchases);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(repository.save(compra));
    }

    @Override
    public Purchase getOne(int id) {
        return mapper.toPurchase(repository.getOne(id));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
