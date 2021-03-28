package com.bykenyodarz.market.domain.repositories;

import com.bykenyodarz.market.domain.viewmodel.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarseProducts(int quantity);

    Product save(Product product);

    Product getOne(int productId);

    void delete(int productId);
}
