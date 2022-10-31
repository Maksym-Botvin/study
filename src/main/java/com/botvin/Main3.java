package com.botvin;

import java.util.Random;

public class Main3 {
    public static void main(String[] args) {

        Random random = new Random();

        int x = random.nextInt(100);

        if ((x % 2) == 0) {
            System.out.println(x + " is an even number");
        } else {
            System.out.println(x + " is an odd number");
        }
    }
}
