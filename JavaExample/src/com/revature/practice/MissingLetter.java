package com.revature.practice;

import java.util.Arrays;

public class MissingLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int i = (int) 'a';
//		System.out.println(i);
//		char c = 97;
//		System.out.println(c);
		char[] ch = {'O','Q','R','S'};
		//System.out.println(missingLetter(ch));
		System.out.printf("Bottle: %10.2f\n", 1.223434);
		
		System.out.printf("Bottle: %10d\n", 8);
		
		System.out.printf("Cans:   %10d\n", 24);
		
		//display("1QS");
		
		System.out.println(Arrays.toString(sortString("Charlie Able Baker")));
	}
	
	public static String[] sortString(String str) {
		String[] arr = str.split(" ");
//		for(int i = 0; i < str.length()-1; i++) {
//			String first = arr[i];
//			for(int j = i +1; j < str.length(); j++) {
//				String second = arr[j];
//				if(first.compareTo(second) > 0) {
//					swap(arr, i, j);
//				}
//			}
//		}
		Arrays.sort(arr);
		return arr;
	}
	
	public static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static char missingLetter(char[] arr) {
		
		int num=0;
		int startingNumber = (int) arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			num = (int) arr[i];
			if(startingNumber != num) {
				return (char) startingNumber;
			}
			startingNumber++;
		}
		return 'a';
	}
	
	public static void display(String str) {
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(Character.isDigit(c)) {
				System.out.println(c);
			} else {
				System.out.println(displayHelper(c));
			}
		}
	}
	
	public static String displayHelper(char c) {
		switch(c) {
		case 'A': return "Ace";
		case 'J': return "Jack";
		case 'Q': return "Queen";
		case 'K': return "King";
		case 'D': return "Diamond";
		case 'H': return "Hearts";
		case 'S': return "Spades";
		case 'C': return "Clubs";
		default: System.out.println("Wrong input");
		}
		return "";
	}

}
