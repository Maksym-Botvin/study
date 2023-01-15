package com.botvin.repository;

import com.botvin.model.Car;
import com.botvin.model.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class CarListRepository implements Crud<Car> {
    private static final List<Car> CARS = new LinkedList<>();
    private static CarListRepository instance;
    private static final BiPredicate<Car, String> CHECK_ID = (car, id) -> car.getId().equals(id);

    private CarListRepository() {
    }

    public static CarListRepository getInstance() {
        if (instance == null) {
            instance = new CarListRepository();
        }
        return instance;
    }

    @Override
    public void save(final Car car) {
        CARS.stream()
                .filter(carsCar -> CHECK_ID.test(carsCar, car.getId()))
                .findAny()
                .ifPresentOrElse(
                        carsCar -> carsCar.setCount(car.getCount()),
                        () -> CARS.add(car)
                );
    }

    @Override
    public Car[] getAll() {
        return CARS.toArray(new Car[0]);
    }

    @Override
    public Optional<Car> getById(final String id) {
        return CARS.stream()
                .filter(carsCar -> CHECK_ID.test(carsCar, id))
                .findAny();
    }

    @Override
    public void delete(final String id) {
        CARS.removeIf(carsCar -> CHECK_ID.test(carsCar, id));
    }

    @Override
    public void insert(String id) {

    }

    @Override
    public void updateColor(String id, Color color) {

    }
}
