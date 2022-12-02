package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Setter
@Getter
public class Car {
    private Random random = new Random();
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;
    private String id;

    public Car() {
    }

    public Car(String manufacturer, Engine engine, Color color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = random.nextInt(100000);
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return String.format("%s, Engine: %s, color: %s", manufacturer, engine, color);
    }
}
