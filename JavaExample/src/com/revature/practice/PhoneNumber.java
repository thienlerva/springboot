package com.revature.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {8,0,4,2,4,5,7,7,5,9};
//		System.out.println(phoneNumber(a));
		//System.out.println(Arrays.toString(smallest(341983)));
		//System.out.println(findUniq(new double[]{1, 1, 1, 0.5, 1, 1}));
		
		String str = "unhappy";
		//str = str.concat("Hello");
		System.out.println(str);
		
		int num = 11;
		String result = num > 10 ? "Greater than 10" : "Lesser than 10";
		System.out.println(result);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate currentDate = LocalDate.now(); // output : 2018-01-09
		System.out.println(currentDate);
		String formattedDate1 = currentDate.format(formatter); // output : 09/01/2018 in
		LocalDate newDate = LocalDate.parse(formattedDate1,formatter);
		System.out.println(newDate);
		
		List<String> strList = Arrays.asList("hello", "hi", "good morning");
		System.out.println(myIterator2(strList).toString());
		
	}
	
	private static Map<String, Integer> myIterator(List<String> inList) {

		
		return inList.stream().filter(str -> str.length() > 5).collect(Collectors.toMap(str -> str, str -> str.length()));
	}
	
	private static HashMap<String, Integer> myIterator2(List<String> inList) {
	    Iterator<String> thisIterator = inList.iterator();
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    while (thisIterator.hasNext()) {
	        String str = thisIterator.next();
	        if (str.length() > 5) {
	            map.put(str, str.length());
	        }
	    }
	    return map;

	}
	
	public static double findUniq(double arr[]) {
		 Map<Double, Integer> map = new HashMap<>();
	      double key = 0.0;
	      int value = 0;
	      for(int i = 0; i < arr.length; i++) {
	        key = arr[i];
	        if(!map.containsKey(key)) {
	          map.put(key, 1);
	        } else {
	          value = map.get(key);
	          map.put(key, ++value);
	        }
	      }
	      
	      Set<Double> keyset = map.keySet();
	      for(Double k : keyset) {
	        if(map.get(k)==1) {
	          return k;
	        }
	      }
	      return arr[0];
	   }
	
	public static String phoneNumber(int[] arr) {
		
		String phoneFormat = new String("(xxx) xxx-xxxx");
		for(int i = 0; i < arr.length; i++) {
			phoneFormat = phoneFormat.replaceFirst("x", Integer.toString(arr[i]));
		}
		return phoneFormat;
	}
	
	 public static long[] smallest(long n) {
	        // your code
		 long[] result = new long[3];
	       String str = Integer.toString((int) n);
	        int min = Character.getNumericValue(str.charAt(0));
	        int index=0, value=0;
	        for(int i = 1; i < str.length(); i++) {
	          value = Character.getNumericValue(str.charAt(i));
	          if(value<min) {
	            min = value;
	            index = i;
	          }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        str = sb.insert(0, min).toString();
	       
	        result[0] = Integer.parseInt(str);
	        result[1] = min;
	        result[2] = index;
	        return result;
	    }

}
