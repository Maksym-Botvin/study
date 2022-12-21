package com.botvin.repository;

import com.botvin.model.Color;

public interface ParameterizedInterfaceCarRepository<T> {
    void save(T object);

    T[] getAll();

    T getById(String id);

    void delete(String id);

    void insert(String id);

    void updateColor(String id, Color color);

}
