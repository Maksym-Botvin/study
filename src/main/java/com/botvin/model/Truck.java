package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Truck extends Car {
    private int loadCapacity;


    public Truck(String manufacturer, Engine engine, Color color, int loadCapacity) {
        super(manufacturer, engine, color);
        this.loadCapacity = loadCapacity;
    }

    public Truck() {

    }

    @Override
    public int restoreCount() {
        return this.loadCapacity = 50;
    }

    @Override
    public String toString() {
        return String.format("manufacturer = %s; Engine = %s; Color = %s; LoadCapacity = %d; ID = %s; typeOfCar = %s; count = %d, price = %d",
                getManufacturer(), getEngine(), getColor(), getLoadCapacity(), getId(), getType(), getCount(), getPrice());
    }
}
