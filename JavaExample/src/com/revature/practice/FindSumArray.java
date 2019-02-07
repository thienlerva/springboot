package com.revature.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindSumArray {

	public static void main(String[] args) {
		
		//System.out.println(isSquare(22));
		//System.out.println(findEvenIndex(new int[] {1,2,3,4,3,2,1}));
		//System.out.println(maskify("325"));
		//System.out.println(getCount("Nope!"));
		//int[] exampleTest1 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
		//System.out.println(find(exampleTest1));
//		int[] arr = {2,2,2,3,2};
//		System.out.println(findNumber(arr));
		
		System.out.println(arithmetic(5, 3, "df"));

	}
	
	public static String reverseWords(final String original)
	  {
	    String[] word = original.split(" ");
	    String result = "";
	    for(int i = 0 ; i < word.length; i++) {
	      result += reverseWord(word[i]) + " ";
	    }
	    return result;
	  }
	  
	  public static String reverseWord(String word) {
	  
	    StringBuilder sb = new StringBuilder(word);
	    
	    return sb.reverse().toString();
	  }
	
	public static int arithmetic(int a, int b, String operator) {
	    
	    switch(operator) {
	      case "add": return a + b;
	      case "subtract": return a - b;
	      case "multiply": return a*b;
	      case "divide": return a/b;
	      default: System.out.println("Wrong input");
	          return 0;
	    }
	  }
	
	public static int findNumber(int[] str) {
	    
	    Map<Integer, Integer> numMap = new HashMap<>();
	    for(int i = 0; i < str.length; i++) {  
	      int key = str[i];
	      if(!numMap.containsKey(key)) {
	        numMap.put(key, 1);
	      } else {
	        int value = numMap.get(key);
	        numMap.put(key, ++value);
	      }
	    }
	    
	    
	    Set<Integer> keys = numMap.keySet();
	    for(Integer i : keys) {
	      if(numMap.get(i) == 1) {
	    	  return i;
	      }
	    }
	    
	    return 0;
	  }
	
	public static boolean findConsecutive(String str, int num) {
		
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			int key = (int) str.charAt(i);
			if(key==num) {
				count++;
			} else {
				count--;
			}
		}
		if(count==3) { return true; }
		else { return false; }
	}
	
	static int find(int[] integers){
	    
		Map<Integer, Integer> evenMap = new HashMap<>();
		Map<Integer, Integer> oddMap = new HashMap<>();
		
		for(int i = 0; i < integers.length; i++) {
			if(oddNumber(integers[i])) {
				oddMap.put(integers[i], 1);
			} else {
				evenMap.put(integers[i], 1);
			}
		}
		
		if(evenMap.size() == 1) {
			Set<Integer> key = evenMap.keySet();
			for(Integer i : key) {
				return i;
			}
		}
		if(oddMap.size() == 1) {
			Set<Integer> key = oddMap.keySet();
			for(Integer i : key) {
				return i;
			}
		}
		return 0;

	}

	  private static boolean oddNumber(int number) {
	    if(number%2 != 0) { return true; }
	    return false;
	  }
	  
	  
	
	public static int getCount(String str) {
	    int vowelsCount = 0;
	    for(int i = 0; i < str.length(); i++) {
	      char c = str.toLowerCase().charAt(i);
	      if( c=='a' || c=='e' || c=='e' || c=='o' || c=='u') {
	        vowelsCount++;
	      }
	    }
	    return vowelsCount;
	  }
	
	public static int factorial(int n) {
	   
		
		if(n==0) return 1;
		if (n < 0 || n > 12)
			throw new IllegalArgumentException("Bad input");
		return n * factorial(n-1);
	    
	    
	  }
	
	public static String maskify(String str) {
       
		if(str.length() <= 4) { return str; }
		else {
		StringBuilder sb = new StringBuilder(str);
		
		for(int i = 0; i < sb.length()-4; i++) {
			sb.setCharAt(i, '#');
		}
        return sb.toString();
		}
    }
	
	public static boolean isSquare(int number) {
		double square = Math.sqrt(number);
		
		int  s = (int) square;
	
		if(Math.pow(s, 2) != number) { return false; }
		else { return true; }
	}
	
	
	public static int findEvenIndex(int[] arr) {
	    
	    int leftSum, rightSum;
	    
	    for(int i = 0; i < arr.length; i++) {
	      leftSum = findSum(arr, 0, i);
	      rightSum = findSum(arr, i+2, arr.length);
	      
	      if(leftSum==rightSum) {
	        return i+1;
	      } 
	      
	    }
	    return -1;
	  }
	  
	  private static int findSum(int[] arr, int startingIndex, int endingIndex) {
	  
	    int length = endingIndex - startingIndex;
	    if(length==0) {
	    	return arr[startingIndex];
	    }
	    else {
	    int[] smallArr = new int[length];
	    
	    int sum=0;
	    while(length>0) {
	    
	     sum += arr[startingIndex];
	     startingIndex++;
	     length--;
	    }
	    
	    return sum;
	    }
	  }

}
