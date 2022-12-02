package com.botvin.util;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random();
    private static String[] manufacturers = {"BMW", "Mercedes", "Audi", "Opel", "VW"};
    private static String[] typesOfEngines = {"Diesel", "Benzine", "Electric"};

    public static int generateRandomNumber() {
        return random.nextInt(0, 11);
    }

    public static String generateRandomManufacture() {
        return manufacturers[random.nextInt(manufacturers.length)];
    }

    public static String generateRandomTypeOfEngine() {
        return typesOfEngines[random.nextInt(typesOfEngines.length)];
    }
}
