package com.botvin;

import com.botvin.model.Car;
import com.botvin.model.UserInputException;
import com.botvin.service.CarService;
import com.botvin.repository.CarRepository;
import com.botvin.util.AlgorithmUtil;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws UserInputException {

        CarService carService = new CarService(new CarRepository());
/*
        Lesson 11
        Object firstCar;
        firstCar = carService.createPassengerCarOrCreateTruck();
        System.out.println(firstCar);

        Object secondCar;
        secondCar = carService.createPassengerCarOrCreateTruck();
        System.out.println(secondCar);

        System.out.println();

        System.out.println(carService.carEquals(carService.createPassengerCarOrCreateTruck(), carService.createPassengerCarOrCreateTruck()));

        System.out.println();

        System.out.println(carService.createPassengerCarOrCreateTruck());

        System.out.println();

 */

/*
        // Lesson 12
        Car car = carService.createPassengerCarOrCreateTruck();

        carService.printManufacturerAndCount(car);

        carService.printColor(car);

        carService.checkCount(car);

        carService.printEngineInfo(car);

        carService.printInfo(car);

 */

        // Lesson 13

        Random random = new Random();

        System.out.println();

        carService.createArrayOfCars(5);
        final Car[] all = carService.getAll();

        String[] carsIds = new String[5];
        for (int i = 0; i < all.length; i++) {
            carsIds[i] = all[i].getId();
        }
        System.out.println(Arrays.toString(carsIds));
        System.out.println(carsIds[0] + " - the first id of our cars' array");

        System.out.println();

        System.out.println("Sorted array:");
        AlgorithmUtil.bubbleSort(carsIds);
        System.out.println(carsIds[0] + " - the first id of our sorted array of cars");

        System.out.println();

        String elementToSearch = carsIds[random.nextInt(0, carsIds.length)];
        System.out.println(elementToSearch + " - wanted item");
        int index = AlgorithmUtil.binarySearch(carsIds, elementToSearch);
        System.out.println("Еhe index of the searched element " + index);

    }
}
