package com.revature.reversedstring;

public class ReversedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReversedString r = new ReversedString();
		
		//System.out.println(r.reverseString("Hello"));
		System.out.println(reverse("Hello"));
	}
	

	
	
	
	public String reverseString(String str) {
		
		String reverse = "";
		
		if(str.length()==1) return str;
		reverse += str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() -1 ));
		
		return reverse;
		
	}
	
	public static String reverse(String str) {
		String result = "";
		
		for(int i = str.length()-1; i >= 0; i--) {
			char ch = str.charAt(i);
			result += ch;
		}
		
		return result;
	}

}
