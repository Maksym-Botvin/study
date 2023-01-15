package com.botvin.repository;

import com.botvin.model.Car;
import com.botvin.model.Color;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;

public class CarMapRepository implements Crud<Car> {
    private static final Map<String, Car> CARS = new LinkedHashMap<>();
    private static CarMapRepository instance;
    private static final BiPredicate<Car, String> CHECK_ID = (car, id) -> car.getId().equals(id);

    private CarMapRepository() {

    }

    public static CarMapRepository getInstance() {
        if (instance == null) {
            instance = new CarMapRepository();
        }
        return instance;
    }


    @Override
    public void save(final Car car) {
        CARS.entrySet()
                .stream()
                .filter(carFromCars -> CHECK_ID.test(carFromCars.getValue(), car.getId()))
                .findAny()
                .ifPresentOrElse(
                        carFromCars -> carFromCars.getValue().setCount(carFromCars.getValue().getCount() + car.getCount()),
                        () -> CARS.put(car.getId(), car)
                );
    }

    @Override
    public Car[] getAll() {
        return CARS
                .values()
                .toArray(new Car[0]);
    }

    @Override
    public Optional<Car> getById(String id) {
        return CARS.values()
                .stream()
                .filter(carsCar -> CHECK_ID.test(carsCar, id))
                .findAny();
    }

    @Override
    public void delete(String id) {
        CARS.remove(id);
    }

    @Override
    public void insert(String id) {

    }

    @Override
    public void updateColor(String id, Color color) {

    }
}
