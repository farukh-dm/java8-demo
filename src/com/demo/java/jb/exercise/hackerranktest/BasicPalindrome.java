package com.demo.java.jb.exercise.hackerranktest;

public class BasicPalindrome {
	
	public static void main(String args[]) throws Exception {
		
		System.out.println("MADAM : " + isPalindrome("MADAM"));
		System.out.println("MADDAM : " + isPalindrome("MADDAM"));
		System.out.println("MAM : " + isPalindrome("MAM"));
		System.out.println("MAAM : " + isPalindrome("MAAM"));
		System.out.println("MAN : " + isPalindrome("MAN"));
		
	}
	
	public static Boolean isPalindrome(String str) {
		
		int length = str.length();
		int last = length-1;
		int middle = (length%2==0) ? length/2 : (length/2)+1;
		//System.out.println("middle: " + middle);
		
		for(int i=0; i<middle; i++) {
			
			//System.out.println("Position: " + i +", "+ (last-i));
			//System.out.println("Value: " + str.charAt(i) +", "+ str.charAt(last-i));
			//System.out.println("==========================");
			if(str.charAt(i) != str.charAt(last-i)) {
				return false;
			}
			
		}
		
		return true;
		
	}
}
