package com.botvin.container;

import com.botvin.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BT_Node<T extends Car> {
    private T car;
    protected int value;
    protected BT_Node left;
    protected BT_Node right;

    public BT_Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
