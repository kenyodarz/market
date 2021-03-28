package com.bykenyodarz.market.domain.services;

import com.bykenyodarz.market.domain.repositories.PurchaseRepository;
import com.bykenyodarz.market.domain.services.apis.PurchaseServiceAPI;
import com.bykenyodarz.market.domain.viewmodel.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService implements PurchaseServiceAPI {

    private final PurchaseRepository repository;

    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return repository.getByClient(clientId);
    }

    @Override
    public Purchase save(Purchase entity) {
        return repository.save(entity);
    }

    @Override
    public List<Purchase> getAll() {
        return repository.getAll();
    }

    @Override
    public Purchase getOne(Integer integer) {
        return repository.getOne(integer);
    }

    @Override
    public void delete(Integer integer) {
        repository.delete(integer);
    }
}
