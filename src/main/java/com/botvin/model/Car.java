package com.botvin.model;
import java.util.Random;
public class Car {

    private Random random = new Random();

    private String manufacturer;
    //private String engine;
    private Engine engine;
    //private String color;
    private Color color;
    private int count;
    private int price;


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setEngine(Engine engine){
        this.engine = engine;
    }
    public Engine getEngine(){
        return engine;
    }

    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
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

    public Car(String manufacturer, Engine engine, Color color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = random.nextInt(100000);
    }

    @Override
    public String toString() {
        return manufacturer;
    }

}
