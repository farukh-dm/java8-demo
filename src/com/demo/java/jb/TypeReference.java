package com.demo.java.jb;

public class TypeReference {
	
	public static void main(String[] args) {
		
		StringLen strLen = (String str) -> str.length();
		StringLen strLen2 = (str2) -> str2.length();
		// Because the compile will try to map this lambda expression to interface method.
		// And it knows that the method takes String argument, so we can pass is like this too.
		
		System.out.println(strLen.getLength("Test"));
		System.out.println(strLen2.getLength("Testing"));
		
		StringAdd strAdd = (a, b) -> a+b;
		System.out.println(strAdd.add("Hello ", "World"));
		
		tryAdd((a, b) -> "Checking "+a+b, "Hello ", "There");
		
	}
	
	public static void tryAdd(StringAdd sa, String s1, String s2) {
		System.out.println(sa.add(s1, s2));
	}
	
}

interface StringLen {
	
	int getLength(String str);
	
}

interface StringAdd {
	
	String add(String str1, String str2);
	
}
