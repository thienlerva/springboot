package com.revature.practice;

import java.util.Stack;

public class PracticeInterview {
	
	public static void main(String[] args) {
		
		PracticeInterview p = new PracticeInterview();
		
		System.out.println(p.isBalance("{[{]}"));
	
	}
	
	public boolean oneEdit(String a, String b) {
		
		if(Math.abs(a.length() - b.length()) > 1) {
			return false;
		}
		else if(Math.abs(a.length() - b.length()) == 1) {
			if(b.contains(a)) return true;
			else if(a.contains(b)) return true;
		}
		
		return false;
	}
	
	
	
	
	public boolean isBalance(String exp) {
		
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++) {
			
			if(exp.charAt(i) == '{' || exp.charAt(i) == '(' || exp.charAt(i) == '[') {
				st.push(exp.charAt(i)); 
			}
			
			if(exp.charAt(i) == '}' || exp.charAt(i) == ')' || exp.charAt(i) == ']') {
				
				 if(!isMatchingPair(st.pop(), exp.charAt(i))) {
					return false;
				}
			}
		}
		
		if (st.isEmpty()) return true;
		else return false;
		
	
	}
	
	private boolean isMatchingPair(char i, char j) {
		
		if(i=='{' && j=='}') return true;
		else if(i=='[' && j==']') return true;
		else if(i=='(' && j==')') return true;
		else return false;
		
	}
	
	
	

}
