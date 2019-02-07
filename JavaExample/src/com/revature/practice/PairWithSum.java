package com.revature.practice;

import java.util.Arrays;

public class PairWithSum {

	public static void main(String[] args) {
		
		int[] arr = {1,2,7,4,5,6,3,8,9};
		//System.out.println(pairWithSum(arr));
		twistedArray(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	public static boolean pairWithSum(int[] arr) {
		
		//Arrays.sort(arr);
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == 8) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void twistedArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 3) { arr[i] = 7; }
			else if(arr[i] == 7) { arr[i] = 3; }
		}
	}

}
