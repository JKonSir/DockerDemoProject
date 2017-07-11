package org.mycompany.repositories;

import org.mycompany.models.GenericEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by konstantinamp on 6/11/17.
 */
public interface EntityRepository<T extends GenericEntity, ID extends Serializable> {

    T findOne(ID  id);

    List<T> findAll();

    T save(T entity);

    void delete(ID id);
}
