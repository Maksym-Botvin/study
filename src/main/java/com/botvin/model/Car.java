package com.botvin.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Setter
@Getter
@EqualsAndHashCode
public abstract class Car implements CountRestore {
    private Random random = new Random();
    private String manufacturer;
    private Engine engine;
    private Color color;
    private Type type;
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
        this.price = random.nextInt(100_000);
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return String.format("%s, Engine: %s, color: %s", manufacturer, engine, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return type == car.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
