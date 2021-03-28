package com.bykenyodarz.market.data.provider;

import com.bykenyodarz.market.data.api.ProductoServiceAPI;
import com.bykenyodarz.market.data.models.Producto;
import com.bykenyodarz.market.data.repository.ProductoJpaRepository;
import com.bykenyodarz.market.generated.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository extends GenericServiceImpl<Producto, Integer> implements ProductoServiceAPI {

    private final ProductoJpaRepository repository;

    public ProductoRepository(ProductoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<Producto, Integer> getRepository() {
        return repository;
    }

    public List<Producto> getByCategoria(int idCategoria){
        return repository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return repository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

}
