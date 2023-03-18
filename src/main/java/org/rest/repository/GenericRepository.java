package org.rest.repository;

import java.util.List;
import java.util.Set;

public interface GenericRepository<T, ID> {
    T getById(ID id);

    Set<T> getAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}
