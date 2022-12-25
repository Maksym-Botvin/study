package com.botvin.container;

import com.botvin.model.Car;

public class Node<T extends Car> {
    protected T car;
    protected Node pPrev;
    protected Node pNext;

    public Node(T car) {
        this.car = car;
    }

    public T getCar() {
        return car;
    }
}
