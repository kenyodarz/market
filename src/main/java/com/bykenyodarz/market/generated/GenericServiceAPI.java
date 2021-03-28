package com.bykenyodarz.market.generated;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<E, ID extends Serializable>  {

    E save(E entity);

    List<E> getAll();

    E getOne(ID id);

    void delete(ID id);

}
