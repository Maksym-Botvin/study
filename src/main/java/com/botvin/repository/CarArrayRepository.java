package com.botvin.repository;

import com.botvin.model.Car;
import com.botvin.model.Color;

import java.util.Optional;

public class CarArrayRepository implements Crud<Car> {

    private static Car[] cars = new Car[10];
    //-----------------------------------------
    private static CarArrayRepository instance;

    public CarArrayRepository() {
    }

    public static CarArrayRepository getInstance() {
        if (instance == null) {
            instance = new CarArrayRepository();
        }
        return instance;
    }
    //--------------------------------------------

    @Override
    public void save(final Car car) {
        final int index = putCar(car);
        if (index == cars.length) {
            final int oldLength = cars.length;
            increaseArray();
            cars[oldLength] = car;
        }
    }

    @Override
    public Car[] getAll() {
        final int newLength = foundLength();
        final Car[] newCars = new Car[newLength];
        System.arraycopy(cars, 0, newCars, 0, newLength);
        return newCars;
    }

    @Override
    public Optional<Car> getById(final String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(final String id) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index].getId().equals(id)) {
                break;
            }
        }
        if (index != cars.length) {
            System.arraycopy(cars, index + 1, cars, index, cars.length - (index + 1));
        }
    }

    public void insert(String id) { // ПІД ПИТАННЯМ!!!
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index].getId().equals(id)) {
                break;
            }
        }
        if (index != cars.length) {
            System.arraycopy(cars, index + 1, cars, index + 1, cars.length - (index + 1));
        }
    }

    // example: insert(7, Car car)
    // якщо 7 комірка не пуста, то потрібно зсунути існуючі значення масиву вправо, а в 7 комірку записати нове
    // якщо 7 комірка пуста, то перевірити, чи, наприклад, 6 комірка не пуста, якщо пуста, то запистаи в 6 комірку
    // if we have empty cell before index -> use first empty cell insted of
    // если у нас есть пустая ячейка перед индексом -> использовать первую пустую ячейку вместо

    // якщо в нас масив масив заповнений (10 машин), то якщо ми хочемо записати нову машину, наприклад, в 2 комірку
    // то викликаємо метод increaseArray(); та робимо зсув "старих" машин вправо

    public void updateColor(final String id, final Color color) {
        getById(id).ifPresent(car -> car.setColor(color));
    }

    private int foundLength() {
        int newLength = 0;
        for (Car car : cars) {
            if (car != null) {
                newLength++;
            } else {
                break;
            }
        }
        return newLength;
    }

    private int putCar(Car car) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index] == null) {
                cars[index] = car;
                break;
            }
        }
        return index;
    }

    private void increaseArray() {
        Car[] newCars = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        cars = newCars;
    }

}