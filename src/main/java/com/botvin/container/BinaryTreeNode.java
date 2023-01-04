package com.botvin.container;

import com.botvin.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode<T extends Car> {
    private T car;
    protected int value;
    protected BinaryTreeNode left;
    protected BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
