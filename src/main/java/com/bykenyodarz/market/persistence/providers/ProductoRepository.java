package com.bykenyodarz.market.persistence.providers;

import com.bykenyodarz.market.domain.repositories.ProductRepository;
import com.bykenyodarz.market.domain.viewmodel.Product;
import com.bykenyodarz.market.persistence.mappers.ProductMapper;
import com.bykenyodarz.market.persistence.repository.ProductoJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private final ProductoJpaRepository repository;
    private final ProductMapper mapper;

    public ProductoRepository(ProductoJpaRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> getAll() {
        return mapper.toProducts(this.repository.findAll());
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return Optional.of(
                mapper.toProducts(
                        repository.findByIdCategoriaOrderByNombreAsc(categoryId)
                ));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return repository.findByCantidadStockLessThanAndEstado(quantity, true)
                .map(mapper::toProducts);
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(repository.save(mapper.toProducto(product)));
    }

    @Override
    public Product getOne(int productId) {
        return mapper.toProduct(repository.findById(productId).orElse(null));
    }

    @Override
    public void delete(int productId) {
        repository.deleteById(productId);
    }
}
