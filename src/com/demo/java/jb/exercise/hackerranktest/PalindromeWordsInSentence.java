package com.demo.java.jb.exercise.hackerranktest;

import java.util.HashSet;
import java.util.Set;

public class PalindromeWordsInSentence {
	
	
	public static void main(String args[]) throws Exception {
		
		System.out.println("palindromeWords: " + findPalindromeWords("My madam is teet civic"));
		System.out.println("palindromeWords: " + findPalindromeWords("madam"));
		
	}
	
	public static Set<String> findPalindromeWords(String str) {
		
		Set<String> palindromeWords = new HashSet<String>();
		
		int length = str.length();
		int last = length-1;
		
		for(int i=0; i<last-1; i++) {
			
			String word = str.charAt(i)+"";
			for(int j=(i+1); j<=last; j++) {
			
				word += str.charAt(j);
				
				//System.out.println(word);
				if(BasicPalindrome.isPalindrome(word)) {
					palindromeWords.add(word);
				}
			
			}
			//System.out.println("---------");
			
		}
		
		return palindromeWords;
		
	}
}
