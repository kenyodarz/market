package com.bykenyodarz.market.shared.generated;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public interface GenericServiceAPI<E, ID extends Serializable>  {

    E save(E entity);

    List<E> getAll();

    E getOne(ID id);

    void delete(ID id);

}
