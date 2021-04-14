package com.devflask.roboflask.database.dao;

import java.util.Collection;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> get(long id);

    Collection<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}