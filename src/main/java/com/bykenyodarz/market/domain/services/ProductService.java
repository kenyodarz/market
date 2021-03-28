package com.bykenyodarz.market.domain.services;

import com.bykenyodarz.market.domain.repositories.ProductRepository;
import com.bykenyodarz.market.domain.services.apis.ProductServiceAPI;
import com.bykenyodarz.market.domain.viewmodel.Product;
import com.bykenyodarz.market.shared.generated.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceAPI {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return repository.getByCategory(categoryId);
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return repository.getScarseProducts(quantity);
    }

    @Override
    public Product save(Product entity) {
        return repository.save(entity);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getOne(Integer integer) {
        return repository.getOne(integer);
    }

    @Override
    public void delete(Integer integer) {
        repository.delete(integer);
    }
}
