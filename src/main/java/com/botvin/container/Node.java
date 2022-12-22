package com.botvin.container;

import com.botvin.model.Car;

public class Node<T extends Car> {
    T car;
    Node pPrev;
    Node pNext;

    public Node(T car) {
        this.car = car;
    }

    public T getCar() {
        return car;
    }
}
