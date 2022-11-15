package com.botvin.service;

import com.botvin.model.Car;
import com.botvin.model.Color;
import com.botvin.model.Engine;

import java.util.Random;

public class CarService {
    private Random random = new Random();
    private String[] manufacturers = {"BMW", "Mercedes", "Audi", "Opel", "VW"};
    private String[] typesOfEngines = {"Diesel", "Benzine", "Electric"};
/*
    private Color[] values = Color.values();
    private int length = values.length;
    private int i = new Random().nextInt(length);
    private Color color = values[i];

    private Engine engine = new Engine(random.nextInt(0, 1000), typesOfEngines[random.nextInt(typesOfEngines.length)]);
 */

    public Car create() {
        String manufacture = manufacturers[random.nextInt(manufacturers.length)];

        Color[] values = Color.values();
        int length = values.length;
        int i = new Random().nextInt(length);
        Color color = values[i];

        Engine engine = new Engine(random.nextInt(0, 1000), typesOfEngines[random.nextInt(typesOfEngines.length)]);

        Car car = new Car(manufacture, engine, color);
        return car;
    }

    public static void check(Car car){

        boolean countStatement;
        boolean powerStatement;

        if (car.getCount() > 0 ){
            countStatement = true;
        }
        else {
            countStatement = false;
            System.out.printf("The count of car %s is less then 1! \n", car);
        }

        if (car.getEngine().getPower() > 200){
            powerStatement = true;
        }
        else {
            powerStatement = false;
            System.out.printf("The power of car %s is less then 200! \n", car);
        }

        if ((countStatement && powerStatement) == true){
            System.out.printf("The car %s is ready to sell! \n", car);
        }
    }

    public static void print(Car car) {
        System.out.printf("Manufacturer: %s, Engine: %s, Color: %s, Count: %d, Price: %d \n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }

}
