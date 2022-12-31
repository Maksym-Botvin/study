package com.botvin.container;

import com.botvin.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarList<T extends Car> {
    private Node head = null;
    private Node tail = null;
    private int length = 0;

    public <T extends Car> void addAtTheBeginning(T car) {
        Node emptyNode = new Node(car);
        if (head == null) {
            head = emptyNode;
            tail = head;
            head.pPrev = null;
            tail.pNext = null;
        } else {
            head.pPrev = emptyNode;
            emptyNode.pNext = head;
            head = emptyNode;
            head.pPrev = null;
        }
        length++;
    }

    public <T extends Car> void addAtTheEnd(T car) {
        if (tail == null) {
            addAtTheBeginning(car);
        } else {
            Node emptyNode = new Node(car);
            tail.pNext = emptyNode;
            emptyNode.pPrev = tail;
            tail = emptyNode;
            tail.pNext = null;
            length++;
        }
    }

    public <T extends Car> int getByTheValue(T car) {
        int index = -1;
        boolean found = false;
        Node current = head;
        while (current.pNext != null) {
            index++;
            if (car.getId().equals(current.getCar().getId())) {
                found = true;
                break;
            }
            current = current.pNext;
        }
        if (found == false) {
            index = -1;
        }
        return index;
    }

    public <T extends Car> void insertValueByTheIndex(int position, T car) {
        if (position <= 0) {
            addAtTheBeginning(car);
        } else if (position >= length) {
            addAtTheEnd(car);
        } else {
            Node newNode = new Node(car);
            Node current = head;
            for (int i = 0; i < position; i++) {
                current = current.pNext;
            }
            newNode.pPrev = current.pPrev;
            newNode.pPrev.pNext = newNode;
            newNode.pNext = current;
            current.pPrev = newNode;
            length++;
        }
    }

    public void deleteByTheIndex(int position) {
        if (length > 0) {
            if (position <= 0) {
                Node newHead = head.pNext;
                head.pNext = null;
                head.pPrev = null;
                newHead.pPrev = null;
                head = newHead;
            } else if (position >= length) {
                Node newTail = tail.pPrev;
                tail.pNext = null;
                tail.pPrev = null;
                newTail.pNext = null;
                tail = newTail;
            } else {
                Node current = head;
                for (int i = 0; i < position; i++) {
                    current = current.pNext;
                }
                current.pPrev.pNext = current.pNext;
                current.pNext.pPrev = current.pPrev;
            }
            length--;
        }
    }

    public int getAllCarCount() {
        Node current = head;
        int count = 1;
        while (current.pNext != null) {
            count += current.getCar().getCount();
            current = current.pNext;
        }
        return count;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.car.getManufacturer());
            current = current.pNext;
        }
    }
}
