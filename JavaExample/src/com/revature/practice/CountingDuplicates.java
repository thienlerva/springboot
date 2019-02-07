package com.revature.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountingDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(duplicateCount("indivisibilities"));
		int[] arr = {3,5,1,5,0,34};
		int[] arr2 = minMax(arr);
		System.out.println(Arrays.toString(arr2));
		
	}
	
	
	public static boolean anagram(String str1, String str2) {
		List<String> list = new ArrayList<>();
		if(str1.length() != str2.length()) {
			return false;
		} else {
			List<Integer> strList1 = new ArrayList<>();
			List<String> strList2 = new ArrayList<>();
			
		}
		return false;
	}
	
	public static int[] minMax(int[] arr) {
	      int[] result = new int[2];
	      
	        Arrays.sort(arr);
	        if(arr.length==1) {
	          result[0] = arr[0];
	          result[1] = arr[0];
	        } else {
	          result[0] = arr[0];
	          result[1] = arr[arr.length -1];
	        }
	        return result;
	    }
	
	public static String duplicateCount(String text) {
	    // Write your code here
		char[] ch = text.toCharArray();
	    Map<Character, Integer> mapText = new HashMap<>();
	    for(int i = 0; i < ch.length; i++) {
	      Character chKey = ch[i];
	      if(!mapText.containsKey(chKey)) {
	        mapText.put(chKey, 1);
	      } else {
	        int value = mapText.get(chKey);
	        mapText.put(chKey, ++value);
	      }
	    }
	    
	   
	    
	    return duplicateResult(mapText);
	  }
	  
	  public static String duplicateResult(Map<Character, Integer> map) {
		  String result = "";
	    Set<Character> keys = map.keySet();
	    for(Character c : keys) {
	      int value = map.get(c);
	      if(value >= 2) {
	        result += c + " occurs " + value + " times";
	      }
	    }
	    return result;
	  }

}
