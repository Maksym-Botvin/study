package com.botvin.container;

import com.botvin.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class CarComparator<T extends Car> {
    private T car;
    public CarComparator(T car) {
        this.car = car;
    }

    // метод, який порівнює за значенням count
    public int countComparator(T car1, T car2) {
        car1.getCount();
        car2.getCount();
        int comparisonResult = car1.getCount() > car2.getCount() ? car1.getCount() : car2.getCount();
        return comparisonResult;
    }

}
