package com.jpmc.LinkedList;

public class Node {
    Node next;
    Integer data;

    public Node(Integer data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;

    public void add(Integer data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(Integer data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void delete(Integer data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void show() {
        Node current = head;
        while (current.next != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }
}
