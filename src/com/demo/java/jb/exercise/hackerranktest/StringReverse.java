package com.demo.java.jb.exercise.hackerranktest;

public class StringReverse {
	
	public static void main(String args[]) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Lorem").append("Ipsum");
		
		System.out.println(sb.reverse().toString());
		
		String str = "LoremIpsum";
		StringBuilder sb2 = new StringBuilder();
		
		for(int i = str.length()-1; i >= 0; i--) {
			
			sb2.append(str.charAt(i));
			
		}
		
		System.out.println(sb2.toString());		
		
	}

}
