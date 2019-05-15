package com.jpmc;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Node node = new Node(10);

        node.insert(3);
        node.insert(20);
        node.insert(1);
        node.insert(5);
        node.insert(12);
        node.printInOrder();
        node.printReversedOrder();
        System.out.println(node.contains(12));
    }
}
