package com.revature.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RemoveDuplicateElementArray {
	
	
	public static void main(String[] args) {
		
		RemoveDuplicateElementArray re = new RemoveDuplicateElementArray();
		int[] array = {5,2,5,1,7,};
		
		//System.out.println(Arrays.toString(re.removeElement(array)));
		removeCharacter("Java2Novice");
	}
	
	public Integer[] removeElement(int[] arr) {
		
		
		Set<Integer> set = new TreeSet<>();
		
		
		Integer[] result = set.toArray(new Integer[0]);
		return result;
		
	}
	
	public static void removeCharacter(String line) {
		
		Map<Character, Integer> mapChar = new TreeMap<>();
		
		char[] ch = line.toCharArray();
		
		for(Character c : ch) {
			if(!mapChar.containsKey(c)) {
				mapChar.put(c, 1);
			} else {
				mapChar.put(c, mapChar.get(c) + 1);
			}
		}
		
		Set<Character> keyset = mapChar.keySet();
		for(Character key : keyset) {
			int count = mapChar.get(key);
			if(count > 1) {
				System.out.println(key + " : " + mapChar.get(key));
			}
		}
	}

}
