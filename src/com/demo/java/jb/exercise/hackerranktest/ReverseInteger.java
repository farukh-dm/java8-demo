package com.demo.java.jb.exercise.hackerranktest;

public class ReverseInteger {
	
	public static void main(String args[]) throws Exception {
		
		// Unsigned variable type of int can hold zero and positive numbers.
		// Signed int holds negative, zero and positive numbers.
		
		System.out.println(reverseInteger(-123));
		System.out.println(reverseInteger(9876));
		System.out.println(reverseInteger(591837));
		
		System.out.println(reverseUnsigedInteger(9876));
		System.out.println(reverseUnsigedInteger(591837));
		
	}
	
	public static long reverseInteger(int number) {
		
		long reverse = 0;
		while(number != 0) {
			
			reverse = (reverse*10)+(number % 10);
			number = number/10;
			
			if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
				//throw exception
				// return 0;
				return 0;
			}
			
			
		}
		
		return reverse;
		
	}
	
	public static long reverseUnsigedInteger(int number) {
		
		
		StringBuilder sb2 = new StringBuilder();
		String str = number+"";
		
		for(int i = str.length()-1; i >= 0; i--) {
			
			sb2.append(str.charAt(i));
			
		}
		
		return Long.parseLong(sb2.toString());
		
	}

}
