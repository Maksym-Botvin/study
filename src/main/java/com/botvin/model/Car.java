package com.botvin.model;

import java.util.Random;
public class Car {

    Random random = new Random();

    private String manufacturer;
    private String engine;
    private String color;
    private int count;
    private int price;


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
    public String getEngine() {
        return engine;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
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


    public Car() {
    }

    public Car(String manufacturer, String engine, String color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = random.nextInt(100000);
    }

}
