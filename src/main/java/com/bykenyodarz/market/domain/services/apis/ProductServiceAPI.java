package com.bykenyodarz.market.domain.services.apis;

import com.bykenyodarz.market.domain.viewmodel.Product;
import com.bykenyodarz.market.shared.generated.GenericServiceAPI;

import java.util.List;
import java.util.Optional;

public interface ProductServiceAPI extends GenericServiceAPI<Product, Integer> {
    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarseProducts(int quantity);
}
