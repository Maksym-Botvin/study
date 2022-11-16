package com.botvin;

import com.botvin.model.Car;
import com.botvin.model.Color;
import com.botvin.model.Engine;
import com.botvin.service.CarService;
import com.botvin.repository.CarRepository;

public class Main {
    public static void main(String[] args) {

        CarService carService = new CarService(new CarRepository());
        Car firstCar = carService.create();
        CarService.print(firstCar);
        CarService.check(firstCar);

        System.out.println();

        Car secondCar = carService.create();
        CarService.print(secondCar);
        CarService.check(secondCar);

        System.out.println();

        Car thirdCar = carService.create();
        CarService.print(thirdCar);
        CarService.check(thirdCar);

        System.out.println();

        Car car4 = carService.create();
        Car car5 = carService.create();
        Car testCar = carService.create();
        carService.printAll();

        System.out.println();

        //carService.insert(String.valueOf(testCar));
        //carService.printAll();

    }
}
