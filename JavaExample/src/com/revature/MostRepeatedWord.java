package com.revature;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MostRepeatedWord {
	
	public static void main(String[] args) {
		
		
		System.out.println(mostWords("Hello world i love you Hello Hello world hello"));
	}
	
	public static String mostWords(String str) {
		
		Map<String, Integer> wordMap = new TreeMap<>();
		
		String key = "";
		int value = 0;
		
		String[] strArray = str.split(" ");
		
		for(int i = 0; i < strArray.length; i++) {
			key = strArray[i].toLowerCase();
			if(!wordMap.containsKey(key)) {
				wordMap.put(key, 1);
			} else {
				value = wordMap.get(key);
				wordMap.put(key, ++value);
			}
		}
		int max = 0;
		String result = "";
		Set<String> keys = wordMap.keySet();
		for(String k : keys) {
			System.out.println("Key: " + k + ", value: " + wordMap.get(k));
			if(wordMap.get(k) > max) {
				max = wordMap.get(k);
				result = k;
			}
		}
		
		
		
		return result;
	}

	
	public static void mostRepeatedWord(String str) {
		
		Map<String, Integer> m = new HashMap<>();
		
		
		String[] arrStr = str.split(" ");
		
		//Arrays.sort(arrStr);
		
		System.out.println(Arrays.toString(arrStr));
		
		
		
		for(String a : arrStr) {
			int i;
			
			
			
			if(!m.containsKey(a.toLowerCase())) {
				
				m.put(a.toLowerCase(), 1);
			}
			else {
				i = m.get(a);
				m.put(a, ++i);
			}
		}
		
		System.out.println(m);
		
		Set<String> keySet = m.keySet();
		
		int max = 0;
		String wordMax = "";
		
		for (String key : keySet) {
			
			Integer value = m.get(key);
			
			System.out.println(key + " : " + value);
			
			if(value > max) {
				max = value;
				wordMax = key;
			}
		}
		
		System.out.println(wordMax + " is the most words: " + max);
		
	}
}
