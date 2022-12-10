package com.botvin.service;

import com.botvin.model.*;
import com.botvin.repository.CarRepository;
import com.botvin.util.RandomGenerator;

import java.util.Random;
import java.util.Arrays;

public class CarService {
    private Random random = new Random();
    private CarRepository carRepository;
    private Type type;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createPassengerCarOrCreateTruck() {
        Type type = Type.randomType();
        String manufacture = RandomGenerator.generateRandomManufacture();
        Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
        if (type.equals(Type.CAR)) {
            PassengerCar passengerCar = new PassengerCar(manufacture, engine, getRandomColor(), getPassengerCount());
            passengerCar.setType(Type.CAR);
            return passengerCar;
        } else if (type.equals(Type.TRUCK)) {
            Truck truck = new Truck(manufacture, engine, getRandomColor(), getPassengerCount());
            truck.setType(Type.TRUCK);
            return truck;
        }
        return null;
    }

    public boolean carEquals(Car firstCar, Car secondCar) {
        if (firstCar.hashCode() == secondCar.hashCode()) {
            if (firstCar.getType().equals(secondCar.getType())) {
                System.out.println("The cars are the same!");
            }
            return true;
        } else {
            return false;
        }
    }

    private int getPassengerCount() {
        PassengerCar passengerCar = new PassengerCar();
        int count = passengerCar.getCount();
        return count;
    }

    private int getLoadCapacity() {
        Truck truck = new Truck();
        int loadCapacity = truck.getLoadCapacity();
        return loadCapacity;
    }

/*
    public void create(int count) {
        for (int i = 0; i < count; i++) {
            carRepository.save(create());
        }
    }
 */

    private Color getRandomColor() {
        Color[] values = Color.values();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    public void printAll() {
        Car[] all = carRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    public Car[] getAll() {
        return carRepository.getAll();
    }

    public Car find(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carRepository.getById(id);
    }

    public void delete(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carRepository.delete(id);
    }

    public void changeRandomColor(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(Car car) {
        Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carRepository.updateColor(car.getId(), randomColor);
    }


    public void insert(String id) {
        carRepository.insert(id);
    }

    public static void check(Car car) {

        boolean countStatement;
        boolean powerStatement;

        if (car.getCount() > 0) {
            countStatement = true;
        } else {
            countStatement = false;
            System.out.printf("The count of car %s is less then 1! \n", car);
        }

        if (car.getEngine().getPower() > 200) {
            powerStatement = true;
        } else {
            powerStatement = false;
            System.out.printf("The power of car %s is less then 200! \n", car);
        }

        if ((countStatement && powerStatement) == true) {
            System.out.printf("The car %s is ready to sell! \n", car);
        }
    }


    public static void print(Car car) {
        System.out.printf("Manufacturer: %s, Engine: %s, Color: %s, Count: %d, Price: %d \n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }
}
