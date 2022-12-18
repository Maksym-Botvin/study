package com.botvin.container;

import com.botvin.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter

public class GreenericContainer<T extends Car> {

    private T car;
    private static Random RANDOM = new Random();

    public GreenericContainer(T car) {
        this.car = car;
    }

    // метод print відображає інформацію про внутрішній об'єкт
    public void print() {
        System.out.printf("Car: %s, type: %s%n", car, car.getClass().getName());
    }

    // метод increaseCount випадковим чином вибирає число в діапазоні 100-300
    // і збільшує поле count внутрішнього об'єкта
    public void increaseCount() {
        car.setCount(RANDOM.nextInt(100, 300));
    }

    // метод increaseCount який приймає будь-яке число (цілочислове або дробове) і збільшує поле count внутрішнього об'єкта
    // цей метод повинен бути параметризовний окремо
    public <N extends Number> void increaseCount(N number) {
        car.setCount(number.intValue());
    }

}
