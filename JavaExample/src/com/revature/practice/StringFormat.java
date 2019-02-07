package com.revature.practice;

import java.io.File;

public class StringFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(formatWords(new String[] {"ninja", "", "ninja3"}));
		File file = new File("C://Users/thienle/Documents/PineLine/");
		String[] fileList = file.list();
		for(String name:fileList){
			System.out.println(name);
		}

	}
	
	public static String formatWords(String[] words) {
	    // Do the things...
		String result = "";
		   
	    if(words==null) { return "";}
      else if(words.length==1) { return words[0]; }
	    else {
	      for(int i = 0; i < words.length; i++) {
	        if(i == words.length-1) {
	          result += " and " + words[i]; 
	        } else if(i==0) {
	        	result = words[i];
	        } else if(words[i]==null) { }
	        else {
	          result += ", " + words[i];
	        }
	      }
	      return result;
	    }
	  }

}
