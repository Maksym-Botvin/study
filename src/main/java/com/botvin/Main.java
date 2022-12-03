package com.botvin;

import com.botvin.model.Car;
import com.botvin.service.CarService;
import com.botvin.repository.CarRepository;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarRepository());

        //carService.createPassengerCar();
        carService.createTruck();
        carService.printAll();

        for (Car car : carService.getAll()) {
            car.restoreCount();
        }
        carService.printAll();
    }
}
