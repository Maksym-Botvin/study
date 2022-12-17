package com.botvin.util;

import java.util.Arrays;

public class AlgorithmUtil {
    public static void bubbleSort(String[] carsIds) {// by ID of car
        String temp = "";
        for (int i = 0; i < carsIds.length; i++) {
            for (int j = i + 1; j < carsIds.length; j++) {
                if (carsIds[i].compareTo(carsIds[j]) > 0) {
                    temp = carsIds[i];
                    carsIds[i] = carsIds[j];
                    carsIds[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(carsIds));
    }

    public static int binarySearch(String[] sortedCarsIds, String elementToSearch) {
        int firstIndex = 0;
        int lastIndex = sortedCarsIds.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (sortedCarsIds[middleIndex].compareTo(elementToSearch) == 0) {
                return middleIndex;
            } else if (sortedCarsIds[middleIndex].compareTo(elementToSearch) < 0) {
                firstIndex = middleIndex + 1;
            } else if (sortedCarsIds[middleIndex].compareTo(elementToSearch) > 0) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
