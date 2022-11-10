package com.botvin.service;

import com.botvin.model.Car;

import java.util.Random;

public class CarService {
    private String[] manufacturers = {"BMW", "Mercedes", "Audi", "Opel", "VW"};
    private String[] engines = {"Diesel", "Benzine", "Electric"};
    private String[] colors = {"Red", "Yellow", "Green", "Blue", "Black", "White"};
    private Random random = new Random();

    public Car create() {
        String manufacture = manufacturers[random.nextInt(manufacturers.length)];
        String engine = engines[random.nextInt(engines.length)];
        String color = colors[random.nextInt(colors.length)];

        Car car = new Car(manufacture, engine, color);
        return car;
    }

    public static void print(Car car) {
        System.out.printf("Manufacturer: %s, Engine: %s, Color: %s, Count: %d, Price: %d \n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }

}
