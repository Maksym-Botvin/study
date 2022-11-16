package com.botvin.model;

import java.util.Random;
import java.util.UUID;

public class Car {

    private Random random = new Random();

    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;
    private String id;


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public Car(String manufacturer, Engine engine, Color color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = random.nextInt(100000);
        this.id = UUID.randomUUID().toString();
    }

    /*
    @Override
    public String toString() {
        return manufacturer;
    }
     */

    @Override
    public String toString() {
        return String.format("[%s] %s", id, color);
    }
}
