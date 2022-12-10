package com.botvin;

import com.botvin.model.Car;
import com.botvin.model.Type;
import com.botvin.service.CarService;
import com.botvin.repository.CarRepository;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarRepository());

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
    }
}
