package com.botvin;

import java.util.Random;

public class Main2 {
    public static void main(String[] args) {

        Random random = new Random();

        int[] randomNum = {0, 0, 0};

        for (int i = 0; i < 3; i++) {
            randomNum[i] = Math.abs(random.nextInt(100));
            System.out.println(randomNum[i]);
        }
        int firstComparison = randomNum[0] < randomNum[1] ? randomNum[0] : randomNum[1];
        int minNum = firstComparison < randomNum[2] ? firstComparison : randomNum[2];
        System.out.println("The smallest number modulo is equal to " + minNum);
    }
}