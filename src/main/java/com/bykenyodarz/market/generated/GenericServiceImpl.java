package com.bykenyodarz.market.generated;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public abstract class GenericServiceImpl<E, ID extends Serializable> implements GenericServiceAPI<E, ID> {


    @Override
    public E save(E entity) {
        return getRepository().save(entity);
    }

    @Override
    public List<E> getAll() {
        return getRepository().findAll();
    }

    @Override
    public E getOne(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    public abstract JpaRepository<E, ID> getRepository();
}
