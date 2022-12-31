package com.botvin.container;

import com.botvin.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarTree<T extends Car> {

    //Represent the node of binary tree
    public static class Node_1 {
        int data;
        public Node_1 left;
        public Node_1 right;

        public Node_1(int data) {
            //Assign data to the new node, set left and right children to null
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Represent the root of binary tree
    public Node_1 root;

    public CarTree() {
        root = null;
    }

    //calculateSum() will calculate the sum of all the nodes present in the binary tree
    public int calculateSum(Node_1 temp) {
        int sum = 0;
        int sumLeft = 0;
        int sumRight = 0;

        //Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
            return 0;
        } else {
            //Calculate the sum of nodes present in left subtree
            if (temp.left != null)
                sumLeft = calculateSum(temp.left);

            //Calculate the sum of nodes present in right subtree
            if (temp.right != null)
                sumRight = calculateSum(temp.right);

            //Calculate the sum of all nodes by adding sumLeft, sumRight and root node's data
            sum = temp.data + sumLeft + sumRight;
            return sum;
        }
    }

    public <T extends Car> void createBinaryTree(BT_Node bt_node, T car) {
        if (car.getCount() < bt_node.value) {
            if (bt_node.left != null) {
                insert(bt_node.left, car.getCount());
            } else {
                System.out.println(" Inserted " + car.getCount() + " to left of " + bt_node.value);
                bt_node.left = new BT_Node(car.getCount());
            }
        } else if (car.getCount() > bt_node.value) {
            if (bt_node.right != null) {
                insert(bt_node.right, car.getCount());
            } else {
                System.out.println("  Inserted " + car.getCount() + " to right of "
                        + bt_node.value);
                bt_node.right = new BT_Node(car.getCount());
            }
        }
    }

    public void insert(BT_Node bt_node, int value) {
        if (value < bt_node.value) {
            if (bt_node.left != null) {
                insert(bt_node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + bt_node.value);
                bt_node.left = new BT_Node(value);
            }
        } else if (value > bt_node.value) {
            if (bt_node.right != null) {
                insert(bt_node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + bt_node.value);
                bt_node.right = new BT_Node(value);
            }
        }
    }

    public void traverseInOrder(BT_Node bt_node) {
        if (bt_node != null) {
            traverseInOrder(bt_node.left);
            System.out.print(" " + bt_node.value);
            traverseInOrder(bt_node.right);
        }
    }


}