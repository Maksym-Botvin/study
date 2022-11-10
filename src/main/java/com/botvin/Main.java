package com.botvin;

import com.botvin.model.Car;
import com.botvin.service.CarService;

public class Main {
    public static void main(String[] args) {

        CarService carService = new CarService();
        Car firstCar = carService.create();
        CarService.print(firstCar);

        Car secondCar = carService.create();
        CarService.print(secondCar);

        Car thirdCar = carService.create();
        CarService.print(thirdCar);

    }
}



