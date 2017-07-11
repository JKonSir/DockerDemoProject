package org.mycompany.services;

import org.mycompany.models.dto.GenericDTO;

import java.util.List;

/**
 * Created by konstantinamp on 7/9/17.
 */
public interface EntityService<T extends GenericDTO, ID extends Object> {

    T getOne(ID subjectId);

    List<T> getAll();

    T add(T subject);

    void remove(ID subjectId);

    T patch(ID subjectId, T subject);
}
