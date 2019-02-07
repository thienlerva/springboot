package com.revature.practice;

import java.util.HashSet;
import java.util.Set;

public class HashCodeEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student alex1 = new Student(1, "Alex");
		Student alex2 = new Student(1, "Alex");
		
		Set<Student> students = new HashSet<>();
		students.add(alex1);
		students.add(alex2);
		
		System.out.println("HashSet size = " + students.size());
		System.out.println("HashSet contains Alex = " + students.contains(new Student(1, "Alex")));
		System.out.println("alex1 hashcode = " + alex1.hashCode());
		System.out.println("alex2 hashcode = " + alex2.hashCode());
		System.out.println("Checking equality between alex1 and alex2 = " + alex1.equals(alex2));
	}

}

class Student {
	
	private int id;
    private String name;
    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean equals(Object obj) {
    	if (obj==null) return false;
    	if (obj==this) return true;
    	if (!(obj instanceof Student)) return false;
    	
    	Student student = (Student) obj;
    	
    	return this.getId() == student.getId();
    }
    
    public int hashCode() {
    	return id;
    }
}
