package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class PassengerCar extends Car {
    private int passengerCount;

    public PassengerCar(String manufacturer, Engine engine, Color color, int passengerCount) {
        super(manufacturer, engine, color);
        this.passengerCount = passengerCount;
    }

    public PassengerCar() {

    }

    @Override
    public int restoreCount() {
        return this.passengerCount = 100;
    }

    @Override
    public String toString() {

        return String.format("manufacturer = %s; Engine = %s; Color = %s; PassengerCount = %d; ID = %s; typeOfCar = %s",
                getManufacturer(), getEngine(), getColor(), getPassengerCount(), getId(), getType());

    }
}
