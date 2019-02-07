package com.revature.practice;

import java.util.Scanner;
import java.util.Stack;

public class PolishExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner in = new Scanner(System.in);
//		Stack<Integer> results = new Stack<>();
//		System.out.println("Enter one number or operant per line, Q to quit");
//		boolean done = false;
//		
//		while(!done) {
//			String input = in.nextLine();
//			
//			//if the command is an operator, pop the arguments and push the results
//			
//			if(input.equals("+")) {
//				results.push(results.pop() + results.pop());
//			} else if (input.equals("-")) {
//				Integer arg2 = results.pop();
//				results.push(results.pop() - arg2);
//			} else if (input.equals("*") || input.equals("x")) {
//				results.push(results.pop() * results.pop());
//			} else if (input.equals("/")) {
//				Integer arg2 = results.pop();
//				results.push(results.pop() / arg2);
//			} else if (input.equals("Q") || input.equals("q")) {
//				done = true;
//			}
//			else {
//				// Not an operator--push the input value
//				results.push(Integer.parseInt(input));
//			}
//			System.out.println(results);
//		}
		
		System.out.println(calculator("345+*"));
	}
	
	public static int calculator(String str) {
		Stack<Integer> result = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c=='+') {
				result.push(result.pop() + result.pop());
			} else if (c=='-') {
				Integer arg2 = result.pop();
				result.push(result.pop() - arg2);
			} else if (c=='*') {
				result.push(result.pop() * result.pop());
			} else if (c=='/') {
				Integer arg2 = result.pop();
				result.push(result.pop() / arg2);
			} else {
				result.push(Character.getNumericValue(c));
			}
		}
		return result.pop();
	}

}
