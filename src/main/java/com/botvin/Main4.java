package com.botvin;

import java.util.Scanner;

public class Main4 {
    static void decimalToBinary(int decimal) {

        int[] arr1 = new int[8];
        int index = 0;
        while (decimal > 0) {
            arr1[index] = decimal % 2;
            decimal = decimal / 2;
            index++;
        }

        for (int i = index - 1; i >= 0; i--) {
            System.out.print(arr1[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Enter a decimal number to convert it to binary: ");
        Scanner scanner = new Scanner(System.in);
        int x = Math.abs(scanner.nextInt());
        decimalToBinary(x);
    }
}