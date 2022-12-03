package com.botvin.service;

import com.botvin.model.*;
import com.botvin.repository.CarRepository;
import com.botvin.util.RandomGenerator;

import java.util.Random;
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

public class CarService {
    private Random random = new Random();
    //private String[] manufacturers = {"BMW", "Mercedes", "Audi", "Opel", "VW"};
    //private String[] typesOfEngines = {"Diesel", "Benzine", "Electric"};
    private CarRepository carRepository;

    // Constructor
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
/*
    public Car create() {
        String manufacture = manufacturers[random.nextInt(manufacturers.length)];
        Engine engine = new Engine(typesOfEngines[random.nextInt(typesOfEngines.length)]);
        Car car = new Car(manufacture, engine, getRandomColor());
        carRepository.save(car);
        return car;
    }
 */
    public PassengerCar createPassengerCar () {
        String manufacture = RandomGenerator.generateRandomManufacture();
        Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
        PassengerCar passengerCar = new PassengerCar(manufacture, engine, getRandomColor(), getPassengerCount());
        passengerCar.setType(Type.CAR);
        carRepository.save(passengerCar);
        return passengerCar;
    }

    public Truck createTruck () {
        String manufacture = RandomGenerator.generateRandomManufacture();
        Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
        Truck truck = new Truck(manufacture, engine, getRandomColor(), getTruckCount());
        truck.setType(Type.TRUCK);
        carRepository.save(truck);
        return truck;
    }
/*
    public int createTruck(RandomGenerator randomGenerator) {
        final int count = randomGenerator.generateRandomNumber();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                Truck truck = createTruck();
                print(truck);
            }
            return count;
        }
        return -1;
    }

    public int createPassengerCar (RandomGenerator randomGenerator) {
        int count = RandomGenerator.generateRandomNumber();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                PassengerCar passengerCar = new PassengerCar();
                print(passengerCar);
            }
        }
        int number = count == 0 ? -1 : count;
        return number;
    }

 */
/*
    public int createTruck (RandomGenerator randomGenerator) {
        int count = RandomGenerator.generateRandomNumber();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                Truck truck = new Truck();
                print(truck);
            }
        }
        int number = count == 0 ? -1 : count;
        return number;
    }

 */

/*
    public int createPassengerCar() {
        int count = RandomGenerator.generateRandomNumber();
        for (int i = 0; i < count; i++) {
            String manufacture = RandomGenerator.generateRandomManufacture();
            Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
            //Color color = null;
            PassengerCar passengerCar = new PassengerCar(manufacture, engine, getRandomColor(), getPassengerCount()); // String manufacture, Engine engine, Color color, int passengerCount
            System.out.println("It's " + (i + 1) + " passengerCar: " + passengerCar);
        }
        int number = count == 0 ? -1 : count;
        return number;
    }

 */


/*
    public int createTruck() {
        int count = RandomGenerator.generateRandomNumber();
        for (int i = 0; i < count; i++) {
            String manufacture = RandomGenerator.generateRandomManufacture();
            Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
            //Color color = null;
            PassengerCar passengerCar = new PassengerCar(manufacture, engine, getRandomColor(), 50); // String manufacture, Engine engine, Color color, int passengerCount
            System.out.println("It's " + (i + 1) + " passengerCar: " + passengerCar);
        }
        int number = count == 0 ? -1 : count;
        return number;
    }

 */

    private int getPassengerCount() {
        PassengerCar passengerCar = new PassengerCar();
        int count = passengerCar.getCount();
        return count;
    }
    private int getTruckCount() {
        Truck truck = new Truck();
        int count = truck.getCount();
        return count;
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
