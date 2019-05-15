package com.jpmc;

public class Node {

    Node left, right;
    Integer data;

    public Node(Integer data) {
        this.data = data;
    }

    public void insert(Integer value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains (Integer value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printReversedOrder() {
        if (right != null) {
            right.printReversedOrder();
        }
        System.out.println(data);
        if (left != null) {
            left.printReversedOrder();
        }
    }
}
