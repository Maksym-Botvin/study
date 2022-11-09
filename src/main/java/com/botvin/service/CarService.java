package com.botvin.service;

import com.botvin.model.Car;

import java.util.Random;

public class CarService {

    public static Car create() {
        Random random = new Random();
        String[] manufacturers = {"BMW", "Mercedes", "Audi", "Opel", "VW"};
        String[] engines = {"Diesel", "Benzine", "Electric"};
        String[] colors = {"Red", "Yellow", "Green", "Blue", "Black", "White"};
        String manufacturer = manufacturers[random.nextInt(manufacturers.length)];
        String engine = engines[random.nextInt(engines.length)];
        String color = colors[random.nextInt(colors.length)];

        int countOne = random.nextInt();
        String count = Integer.toString(countOne);
        int priceOne = random.nextInt();
        String price = Integer.toString(priceOne);

        Car car = new Car(manufacturer, engine, color);
        return car;
    }

    public static void print(Car car) {
        System.out.printf("Manufacturer: %s, Engine: %s, Color: %s, Count: %d, Price: %d \n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }

}
