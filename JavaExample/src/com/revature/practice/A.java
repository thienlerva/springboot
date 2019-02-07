package com.revature.practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public interface A {
	public static String name="A";
	
	void print();
	default void printA() {
		System.out.println(name);
	}
}

interface B {
	void doSth();
}

class Child implements A,B {

	private String name;
	
	public Child() {
		name = "Le";
	}
	@Override
	public void doSth() {
		// TODO Auto-generated method stub
		System.out.println("IN CHILD CLASS, DO B INTERFACE");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("IN CHILD CLASS, print A INTERFACE");
	}
	
	public static void main(String[] args) {
		
		Collection<String> c = new ArrayList<>();
		c.add("5");
		Iterator<String> i = c.iterator();
		
		A a = new Child();
		a.printA();
		
		Child ch = new Child();
		ch.doSth();
	}
	
}
