package com.botvin;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of the triangle's sides in turn [cm]: ");
        float[] sides = {0, 0, 0};
        float perimeter = 0;

        for (int i = 0; i < 3; i++) {
            sides[i] = scanner.nextFloat();
            perimeter += sides[i];
        }

        float a = sides[0];
        float b = sides[1];
        float c = sides[2];

        if (a + b > c && b + c > a && a + c > b) {
            float p = perimeter / 2; // p - half perimeter of a triangle
            float areaOfTriangle = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("The area of the triangle is equal " + areaOfTriangle + " cm2");
        } else {
            System.out.println("It's not a triangle!");
        }
    }
}