package com.botvin.model;

import java.util.Random;

public enum Type {
    CAR,
    TRUCK;

    private static final Random randomType = new Random();

    public static Type randomType() {
        Type[] randomIndex = values();
        return randomIndex[randomType.nextInt(randomIndex.length)];
    }
}
