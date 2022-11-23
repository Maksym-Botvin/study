package com.botvin.model;

import java.util.Random;

public class Engine {
    Random random = new Random();

    private int power;
    private String type;

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Engine(String type) {
        this.power = random.nextInt(0, 1000);
        this.type = type;

    }

    @Override
    public String toString() {
        return "power = " + power + ", type = " + type;
    }

}
