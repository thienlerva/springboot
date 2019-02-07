package com.revature.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NumberCharacter {
	
	public static void main(String[] args) {
		
		//numCharMap("racecar");
		
		//sortNumber(34194013);
		//System.out.println(Arrays.toString(arr));
		
//		int[] arr = {5,2,9,2,0};
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
//		
		
		
		
		
	}
	
	static void numCharacter(String line) {
		
		Character aCharacter=line.charAt(0);
		int count = 0;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i)==aCharacter) {
				count++;
			}
		}
		
		//int[] arr = sortNumber(34194013);
		//System.out.println(Arrays.toString(arr));
		
	}
	
	static void numCharMap(String word) {
		Map<Character, Integer > map = new HashMap<>();
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(map.containsKey(c)) {
				int count = map.get(c);
				map.put(c, ++count);
			}
			else {
		
				map.put(c, 1);
			}
		}
		
		Set<Character> keyset = map.keySet();
		
		//char[] alpha = Arrays.sort(unique.toArray());
		String[] result = new String[map.size()];
		int i = 0;
		for(Character key : keyset) {
			
			result[i] = key + " " + map.get(key);
			i++;
		}
		
		Arrays.sort(result);
		System.out.println(Arrays.toString(result));
		
	
		
	}
	
	public void sortInts (int input) {
		
		int[] arr = new int[10];
		while(input > 0) {
			int temp = input % 10;
			arr[temp]++;
			input = input/10;
		}
		
		for(int i=0; i<10; i++) {
			while(arr[i] !=0) {
				System.out.println(i);
				arr[i]--;
			}
		}
		
		
	}
	
public int reverseNumber(int number){
		
		int reverse = 0;
		while(number != 0){
			reverse = (reverse*10)+(number%10);
			number = number/10;
		} 
		return reverse;
	}

	public static void sortNumber (int input) {
		
		String line = Integer.toString(input);
		int[] result = new int[line.length()];
		
		// appending each number to array
		for(int i = 0; i < result.length; i++) {
			result[i] = line.charAt(i);
		}
		
		//Arrays.sort(result);
		
		for(int i : result) {
			System.out.println(i);
		}
	}
	

}
