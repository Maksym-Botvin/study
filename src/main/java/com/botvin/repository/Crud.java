package com.botvin.repository;

import com.botvin.model.Car;
import com.botvin.model.Color;

import java.util.Optional;

public interface Crud<T> {
    void save(final T car);

    T[] getAll();

    Optional<Car> getById(final String id);

    void delete(final String id);

    void insert(final String id);

    void updateColor(final String id, Color color);
}
