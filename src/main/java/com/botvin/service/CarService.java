package com.botvin.service;

import com.botvin.model.*;
import com.botvin.repository.CarRepository;
import com.botvin.util.RandomGenerator;

import java.util.*;

public class CarService {
    private Random random = new Random();
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create() {
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

    public void createArrayOfCars(final int sizeOfArray) {
        for (int i = 0; i < sizeOfArray; i++) {
            carRepository.save(create());
        }
    }

    public void create(final int count) {
        for (int i = 0; i < count; i++) {
            carRepository.save(create());
        }
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

    public void printManufacturerAndCount(final Car car) {
        Optional.ofNullable(car).ifPresent(value -> {
            System.out.printf("Manufacturer: %s, count: %d.\n", value.getManufacturer(), value.getCount());
        });
    }

    public void printColor(final Car car) {
        Car value = Optional.ofNullable(car).orElse(new PassengerCar(getRandomManufacture(), getRandomEngine(),
                getRandomColor(), getPassengerCount()));
        System.out.println("Color: " + car.getColor().toString());
    }

    public void checkCount(final Car car) throws UserInputException {
        Car value = Optional.ofNullable(car)
                .filter(valueFilter -> valueFilter.getCount() >= 0) // valueFilter.getCount() >= 10
                .orElseThrow(() -> new UserInputException());
        System.out.printf("Manufacturer: %s, count: %d.\n", value.getManufacturer(), value.getCount());
    }

    public void printEngineInfo(final Car car) {
        Car value = Optional.ofNullable(car)
                .orElseGet(() -> {
                    System.out.println("Create new car!");
                    return createPassengerCarOrCreateTruck();
                });
        Optional.of(value.getEngine())
                .map(eng -> {
                    System.out.printf("Engine power: %d.\n", eng.getPower());
                    return value.getEngine().toString();
                });
    }

    public void printInfo(final Car car) {
        Optional.ofNullable(car).ifPresentOrElse(
                value -> print(car),
                () -> print(createPassengerCarOrCreateTruck())
        );
    }

    public void print(final Car car) {
        System.out.println(car);
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

    private Engine getRandomEngine() {
        Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
        return engine;
    }

    private String getRandomManufacture() {
        String manufacture = RandomGenerator.generateRandomManufacture();
        return manufacture;
    }

    private Color getRandomColor() {
        Color[] values = Color.values();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    public void printAll() {
        Car[] all = carRepository.getAll();
        for (Car car : all) {
            System.out.println(car);
        }
    }

    /*
        public void printAll() {
        Car[] all = carRepository.getAll();
        System.out.println(Arrays.toString(all));
    }
     */
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

    // New CarServices' methods
    public HashMap<String, Integer> returnManufacureAndCount(Car[] cars) {
        HashMap<String, Integer> map = new HashMap<>();
        for (Car car : cars) {
            map.put(car.getManufacturer(), car.getCount());
        }
        return map;
    }

    public HashMap<Integer, LinkedList> returnEnginePowerAndList(Car[] cars) {
        HashMap<Integer, LinkedList> map = new HashMap<>();
        LinkedList<Car> carList;
        for (Car car : cars) {
            int power = car.getEngine().getPower();
            if (map.containsKey(power)) {
                carList = map.get(power);
                carList.add(car);
            } else {
                map.put(power, new LinkedList<>());
                carList = map.get(power);
                carList.add(car);
            }
        }
        return map;
    }
/*
    public static void print(Car car) {
        System.out.printf("Manufacturer: %s, Engine: %s, Color: %s, Count: %d, Price: %d \n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }

 */
}
