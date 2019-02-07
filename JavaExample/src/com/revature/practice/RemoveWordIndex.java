package com.revature.practice;

import java.util.List;
import java.util.ArrayList;

public class RemoveWordIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String line = "afdf fdf  ";
//		System.out.println(line.trim());
//		
//		System.out.println(pigIt("Hello world !"));
		
		for(int i = 'a'; i <= 'z'; i++) {
		    System.out.println((char) i + " : " + (i - 'A' + 1));
		}
	}
	
	public static String pigIt(String str) {
        String[] words = str.split(" ");
        List<String> list = new ArrayList<>();
        String result = "";
        
        for(int i = 0; i < words.length; i++) {
          list.add(removeWord(words[i]));
        }
        
        for(String l : list) {
        	result += l + " ";
        }
        
        return result.trim();
    }
    
    public static String removeWord(String str) {
    	if(str.length()==1) { return str; } 
    	else {
      char ch = str.charAt(0);
      return str.substring(1) + ch + "Ay";
    	}
    }

}
