package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Engine {
    private Random random = new Random();
    private int power;
    private String type;

    public Engine(String type) {
        this.power = random.nextInt(0, 1000);
        this.type = type;
    }

    @Override
    public String toString() {
        return "power = " + power + ", type = " + type;
    }
}
