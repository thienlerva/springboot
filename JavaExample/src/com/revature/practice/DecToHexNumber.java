package com.revature.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DecToHexNumber {
	
	public static void main(String[] args) {
		
		Set<Integer> set = new TreeSet<>();
		set.add(10);
		set.add(20);
		System.out.println(set);
		
		System.out.println(run(30));
		
//		System.out.println(Integer.toHexString(16));
//		System.out.println(Integer.parseInt("10", 16));
		
		
//		int[] socks = { 20, 20, 10,20,30,10,40,30,10,20,40, 10};
//		
//		Map<Integer, Integer> result = pairOfSocks(socks);
//		
//		Set<Integer> keyset = result.keySet();
//		
//		for(Integer key : keyset) {
//			System.out.println("Sock size: " + key + " has: " + result.get(key));
//		}
		
		String name = "Hello";
		name = name.substring(2, name.length());
		System.out.println(name);
		
		System.out.println(Integer.toBinaryString(258));
		System.out.println(convertToBinary(258));
		System.out.println(binaryToDecimal("100000010"));
		System.out.println(checkBinary(110000001));
		
	}
	
	public static boolean checkBinary(int num) {
		
		if(num==0) return true;
		
		while(num>0) {
			if(num%10>1) return false;
			else {
				num = num/10;
			}
		}
		return true;
	}
	
public static StringBuilder convertToBinary(int decimal) {
		
		StringBuilder sb = new StringBuilder();
		
		while(decimal > 0) {
			int remainder = decimal % 2;
			decimal /= 2;
			sb.append(remainder);
			
		}
		
		return sb.reverse();
	}
	
	public static int binaryToDecimal(String binaryNum) {
		
		char[] c = binaryNum.toCharArray();
		int total = 0;
		for(int i = 0; i < c.length; i++) {
			total = total*2 + Character.getNumericValue(c[i]);
		}
		
		return total;
	}
	
	
	static Map<Integer, Integer> pairOfSocks(int[] arr) {
		
		Map<Integer, Integer> sockMap = new TreeMap<>();
		
		int count;
		int size;
		
		for(int i = 0; i < arr.length; i++) {
			
			size = arr[i];
			if(!sockMap.containsKey(size)) {
				sockMap.put(size, 1);
			} else {
				count = sockMap.get(size);
				sockMap.put(size, ++count);
			}
		}
		
		
		
		Set<Integer> keyset = sockMap.keySet();
		
		int numOfPair;
		for(Integer key : keyset) {
			numOfPair = sockMap.get(key);
			sockMap.put(key, numOfPair/2);
		}
		
		return sockMap;
	}
	
	
	static int sockMerchant( int[] ar) {
        int count = 0;    
        
        HashSet<Integer> socks = new HashSet<Integer>();
        for(int i = 0; i < ar.length; i++) {
            if(socks.contains(ar[i])) {
                count++;
                socks.remove(ar[i]);
            }
            else {
                socks.add(ar[i]);
            }
        }
        
        return count;
       }
	
	public static String run(int n) {

        if(n>0) 
        {
            return findHex(n);
        }
        else if(n < 0){
            String negative = "-" + findHex(-n);
            return negative;
        }
        else{
            return "0";
        }

    }

    static String findHex(int n){
        // convert int n to hex string 

        String hex = "";
        //0-9, a 10, b 11, c 12, d 13, e 14, f 15 

        // 30 - 1e
        Map<Integer, String> values = new HashMap<>();
        values.put(0, "0");
        values.put(1, "1");
        values.put(2, "2");
        values.put(3, "3");
        values.put(4, "4");
        values.put(5, "5");
        values.put(6, "6");
        values.put(7, "7");
        values.put(8, "8");
        values.put(9, "9");
        values.put(10, "a");
        values.put(11, "b");
        values.put(12, "c");
        values.put(13, "d");
        values.put(14, "e");
        values.put(15, "f");

        while(n > 0){
            int curr = n % 16; // 14

            hex += values.get(curr); // 21

            n /= 16; // 1
        }

        StringBuilder sb = new StringBuilder(hex);
        return sb.reverse().toString();


    }
	
	private String alphabet(int num) {
		
		switch(num) {
			
		case 10: return "a";
		case 11: return "b";
		case 12: return "c";
		case 13: return "d";
		case 14: return "e";
		case 15: return "f";
		default:
			return "o";
		}
		
	}
	
	
	
}
