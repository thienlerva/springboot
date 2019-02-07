package com.revature.practice;

public class Singleton {
	
	private static Singleton obj;
	
	static {
		obj = new Singleton();
	}
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return obj;
	}
	
	public void testMe() {
		System.out.println("This is Singleton");
	}
	
	public static void main(String[] args) {
		Singleton ms = getInstance();
		ms.testMe();
	}

}
