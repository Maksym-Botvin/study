package com.botvin;

import com.botvin.model.Car;
import com.botvin.model.Type;
import com.botvin.model.UserInputException;
import com.botvin.service.CarService;
import com.botvin.repository.CarRepository;

import java.util.Optional;

public class Main {
    public static void main(String[] args) throws UserInputException {
        CarService carService = new CarService(new CarRepository());
/*
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
        Car car = carService.createPassengerCarOrCreateTruck();

        carService.printManufacturerAndCount(car);

        carService.printColor(car);

        carService.checkCount(car);

        carService.printEngineInfo(car);

        carService.printInfo(car);

    }
}
