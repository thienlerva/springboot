package com.revature.practice;

public class CommonNumber {
	
	public static void main(String[] args) {
		
		int decNumber = 10;
		System.out.println(Integer.toHexString(25));
		System.out.println(Integer.toBinaryString(12));
		
		System.out.println(Integer.parseInt("1100", 2));
		
		String line = "hello";
		char[] ch = line.toCharArray();
		
		for(char c : ch) {
			System.out.println(c);
		}
		
		int[] arr1 = {2,5,1,5,5,2};
		int[] arr2 = {4,2,6,3,5};
		
//		for(int i = 0; i < arr1.length; i++) {
//			for(int j = 0; j < arr2.length; j++) {
//				if(arr1[i]==arr2[j]) {
//					System.out.println(arr1[i]);
//				}
//			}
//		}
	}

}
