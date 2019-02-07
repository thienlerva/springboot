package com.revature.practice;

import java.util.List;
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<User> u = new ArrayList<>();
//		List<Employee> e = new ArrayList<>();
		User u = new User();
		Employee e = new Employee();
		//u = e; can convert
		User u1 = new User();
		u = u1;
	}

}

class User {
	private String name;
}

class Employee {
	private String name;
}
