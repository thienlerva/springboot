package com.revature.practice;

import java.util.Arrays;

public class Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,9,-4,-7,-5,-1};
		//System.out.println(highestDay(arr, 100));
		System.out.println(Arrays.toString(mystery(5, 10)));
	}
	
	public static int highestDay(int[] arr, double price) {
		double max = arr[0];
		int index =0;
		
		for(int i = 1; i < arr.length; i++) {
			price += arr[i];
			if(max < price) {
				max = price;
				index = i;
			}
		}
		return index;
	}
	
	public static int[] mystery(int length, int n) {
		int[] result = new int[length];
		
		for(int i = 0; i < result.length; i++) {
			result[i] = (int) (n*Math.random());
		}
		
		return result;
	}

}
