package com.botvin.service;

import com.botvin.model.*;
import com.botvin.repository.CarRepository;
import com.botvin.util.RandomGenerator;

import java.util.Objects;
import java.util.Random;
import java.util.Arrays;

public class CarService {
    private Random random = new Random();
    private CarRepository carRepository;
    private Type type;

    // Constructor
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createPassengerCarOrCreateTruck() { // public Car createPassengerCarOrCreateTruck (Type type)
        String manufacture = RandomGenerator.generateRandomManufacture();
        Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
        PassengerCar passengerCar = new PassengerCar(manufacture, engine, getRandomColor(), getPassengerCount());
        Truck truck = new Truck(manufacture, engine, getRandomColor(), getLoadCapacity());
        Type type = Type.randomType();
        if (type.equals(Type.CAR)) {
            passengerCar.setType(Type.CAR);
            carRepository.save(passengerCar);
            return passengerCar;
        } else if (type.equals(Type.TRUCK)) {
            truck.setType(Type.TRUCK);
            carRepository.save(truck);
            return truck;
        }
        Object object;
        object = type.equals(Type.CAR) ? passengerCar : truck;
        return passengerCar; //object;
    }

    public boolean carEquals(Car firstCar, Car secondCar) {
        if (firstCar.hashCode() == secondCar.hashCode()) {
            System.out.println("The hashCode of the firstCar == the hashCode of the secondCar");
            if (firstCar.getType().equals(secondCar.getType())) {
                System.out.println("The type of the firstCar is equals to the type of the secondCar");
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarService that = (CarService) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
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

/*
    public int createCars() {
        int count = RandomGenerator.generateRandomNumber();
        for (int i = 0; i < count; i++) {
            String manufacture = RandomGenerator.generateRandomManufacture();
            Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
            Car car = new Car(manufacture, engine, getRandomColor());
            System.out.println("It's " + (i + 1) + " car: " + car);
        }
        int number = count == 0 ? -1 : count;
        return number;
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
