package com.bykenyodarz.market.domain.repositories;

import com.bykenyodarz.market.domain.viewmodel.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clientId);

    Purchase save(Purchase purchase);

    Purchase getOne(int id);

    void delete(int id);
}
