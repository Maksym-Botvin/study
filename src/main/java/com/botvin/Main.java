package com.botvin;

import com.botvin.model.Car;
import com.botvin.model.Color;
import com.botvin.model.Engine;
import com.botvin.service.CarService;

public class Main {
    public static void main(String[] args) {

        CarService carService = new CarService();
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




    }
}



