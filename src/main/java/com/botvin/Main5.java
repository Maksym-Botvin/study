package com.botvin;

import java.util.Random;
import java.util.Arrays;


public class Main5 {

    // This method was created to additional home task
    static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int firstNumber = numbers[i];
            int secondNumber = numbers[i + 1];
            if (firstNumber > secondNumber) {
                int temp = firstNumber;
                firstNumber = secondNumber;
                secondNumber = temp;
            }
            numbers[i] = firstNumber;
            numbers[i + 1] = secondNumber;
        }
    }

    public static void main(String[] args) {

        // 1-st task
        /*
        Створіть масив з 12 випадкових цілих чисел з відрізка [-15;15]. Визначте який
        елемент є в цьому масиві максимальним і повідомте індекс його останнього
        входження в масив. (приклад: 11, 0, 14, -4, 0, 14, 3 -> index = 5).
         */

        int[] array = new int[12];
        System.out.println(Arrays.toString(array) + " - new empty array");
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-15, 15);
        }
        System.out.println(Arrays.toString(array) + " - filled array");

        int maxValue = array[0];
        int index = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] >= maxValue) {
                maxValue = array[j];
                index = j;
            }
        }
        System.out.println(maxValue + " - max value of the array");
        System.out.println(index + " - index of the last highest element");

        System.out.println();

        // 2-nd task

        /*
        Створіть масив із 8 випадкових цілих чисел з відрізка [1;10]. Виведіть масив на
        екран у рядок. Замініть кожен елемент з непарним індексом на нуль. Знову
        виведіть масив на екран в окремому рядку
         */

        int[] array1 = new int[8];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(1, 10);
        }
        System.out.println(Arrays.toString(array1) + " - new generated array");
        for (int j = 0; j < array1.length; j++) {
            if (j % 2 == 1) {
                array1[j] = 0;
            }
        }
        System.out.println(Arrays.toString(array1) + " - an array in which odd indices are replaced by 0");

        System.out.println();

        // 3-rd task

        /*
        Створіть масив з 4 випадкових цілих чисел з відрізка [10;99]. Виведіть його на
        екран у рядок. Далі визначте та виведіть на екран повідомлення про те, чи є
        масив строго зростаючою послідовністю (приклад: 11, 23, 45, 66).
         */

        int[] array2 = new int[4];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = random.nextInt(10, 99);
        }
        System.out.println(Arrays.toString(array2) + " - new generated array \"array2\"");
        int[] array3 = Arrays.copyOf(array2, array2.length);
        Arrays.sort(array3);
        System.out.println(Arrays.toString(array3) + " - sorted array \"array3\"");
        if (Arrays.equals(array2, array3)) {
            System.out.println("array2 - is a strictly increasing sequence");
        }

        System.out.println();

        // 4-th task

        /*
        Створіть 2 масиви з 5 випадкових цілих чисел з відрізка [0;5] кожен. Виведіть
        масиви на екран у двох окремих рядках . Порахуйте середнє арифметичне
        елементів кожного масиву і повідомте, для якого з масивів це значення виявилося
        більшим (або повідомте, що їхні середні арифметичні рівні)
         */

        int[] myArray1 = new int[5];
        int[] myArray2 = new int[5];
        for (int i = 0; i < myArray1.length; i++) {
            myArray1[i] = random.nextInt(0, 5);
        }
        System.out.println(Arrays.toString(myArray1) + " - myArray1");
        for (int j = 0; j < myArray2.length; j++) {
            myArray2[j] = random.nextInt(0, 5);
        }
        System.out.println(Arrays.toString(myArray2) + " - myArray2");

        float total1 = 0;
        float total2 = 0;
        float arithmeticMean1 = 0F;
        float arithmeticMean2 = 0F;
        for (int num1 = 0; num1 < myArray1.length; num1++) {
            total1 += myArray1[num1];
        }
        arithmeticMean1 = total1 / myArray1.length;
        System.out.println(arithmeticMean1 + " - arithmeticMean1");
        for (int num2 = 0; num2 < myArray2.length; num2++) {
            total2 += myArray2[num2];
        }
        arithmeticMean2 = total2 / myArray2.length;
        System.out.println(arithmeticMean2 + " - arithmeticMean2");
        if (arithmeticMean1 > arithmeticMean2) {
            System.out.println("The arithmetic mean of the myArray1 is greater then myArray2");
        } else if (arithmeticMean1 == arithmeticMean2) {
            System.out.println("The arithmetic mean of the myArray1 is equals to the myArray2");
        } else {
            System.out.println("The arithmetic mean of the myArray2 is greater then myArray1");
        }

        System.out.println();

        // 5-th additional task home task

        final int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers) + " - initial array");

        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbersCopy);
        System.out.println(Arrays.toString(numbersCopy) + " - sorted array");

        int k = 1;
        while (k <= numbers.length) {
            bubbleSort(numbers);
            if (Arrays.equals(numbers, numbersCopy)) {
                //System.out.printf("At the " + k + " iteration the array \"numbers\" %s is equals to the array \"numbersCopy\" %s%n", Arrays.toString(numbers), Arrays.toString(numbersCopy));
                System.out.println("At the " + k + " iteration the array \"numbers\" " + Arrays.toString(numbers) + " - is sorted!");
                break;
            }
            System.out.println(Arrays.toString(numbers) + " " + k + "-iteration");
            k++;
        }
    }

}
