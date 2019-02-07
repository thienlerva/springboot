package com.revature.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

public class MinMaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(minMaxString("3,1,5,0,2,9,1"));
		
//		int[] arr = {5, 3, 2, 8, 1, 4};
//		int[] arr2 = sortArray(arr);
//		System.out.println(Arrays.toString(arr2));
		
	
		//System.out.println(whoLikesIt("A, B, C"));
		System.out.println(palindrome("Madam"));
		StringBuilder sb1 = new StringBuilder("12121");
		System.out.println(sb1.reverse());
	}
	
	public static boolean palindrome(String str) {
		if(str==null || str.length()==0) return true;
		StringBuilder sb = new StringBuilder(str);
		if(sb.reverse().toString().equalsIgnoreCase(str)) return true;
		return false;
	}
	
	public static int digital_root(int n) {
	    // ...
		while(n>10){
		      String NumberAsString = String.valueOf(n);
		      
		      n = 0;
		      for(char c:NumberAsString.toCharArray()){
		        n += Character.getNumericValue(c);
		      }
		    }
		    
		    return n;
	}
	
	public static boolean isSquare(int number) {
		int sqr = (int) Math.sqrt(number);
		if(number == Math.pow(sqr, 2)) return true;
		return false;
	}
	
	public static String whoLikesIt(String... names) {
		switch (names.length) {
        case 0: return "no one likes this";
        case 1: return String.format("%s likes this", names[0]);
        case 2: return String.format("%s and %s like this", names[0], names[1]);
        case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
        default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
      }
    }
	
	public static int[] sortArray(int[] array) {
		  
	    for(int i = 0; i < array.length-1; i++) {
	      int first = array[i];
	      if(oddNumber(first)) {
	        for(int j = i + 1; j < array.length; j++) {
	          int second = array[j];
	          if(oddNumber(second) && first > second) {
	            swap(array, i, j);
	          }
	        }
	      }
	    }
	    return array;
	  }
	  
	  public static boolean oddNumber(int number) {
	    if(number%2==0) {
	      return false;
	    }
	    return true;
	  }
	  
	  public static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }
	
	public static boolean anagram(String str1, String str2) {
	
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		if(str1.length() != str2.length()) {
			return false;
		} else {
			List<Character> strList1 = new ArrayList<>();
			List<Character> strList2 = new ArrayList<>();
			for(char c : ch1) {
				strList1.add(c);
			}
			for(char c : ch2) {
				strList2.add(c);
			}
			
			for(int i = 0; i < strList1.size(); i++) {
				for(int j = 0; j < strList2.size(); j++) {
					if(strList1.get(i)==strList2.get(j)) {
						strList1.remove(i);
						strList2.remove(j);
					}
				}
			}
			
			if(strList1.size() >= 1) {
				return false;
			} else {
				return true;
			}
			
		}
		
	}
	
	public static String oddOrEven (int[] array) {
	    
	    int result = 0;
	    for(int i = 0; i < array.length; i++) {
	      result += array[i];
	    }
	    
	    if(result%2==0) {
	      return "even";
	    } else {
	      return "odd";
	    }
	  }
	
	public static String minMaxString(String number) {
		
		String[] arrayString = number.split(",");
		
		int[] arrayNumber = new int[arrayString.length];
		
		for(int i = 0; i < arrayString.length; i++) {
			arrayNumber[i] = Integer.parseInt(arrayString[i]);
		}
		
		int min = arrayNumber[0];
		int max=0;
		
		for(int i = 1; i < arrayNumber.length; i++) {
			int n = arrayNumber[i];
			if(n > max) {
				max=n;
			}
			if(n < min) {
				min = n;
			}
		}
		
		return "Min: " + min + ", max: " + max;
	}

}
