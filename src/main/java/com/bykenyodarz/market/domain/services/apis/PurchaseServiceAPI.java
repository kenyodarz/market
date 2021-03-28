package com.bykenyodarz.market.domain.services.apis;

import com.bykenyodarz.market.domain.viewmodel.Purchase;
import com.bykenyodarz.market.shared.generated.GenericServiceAPI;

import java.util.List;
import java.util.Optional;

public interface PurchaseServiceAPI extends GenericServiceAPI<Purchase, Integer> {
    Optional<List<Purchase>> getByClient(String clientId);

}
