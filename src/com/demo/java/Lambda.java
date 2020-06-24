package com.demo.java;

import java.util.Comparator;
import java.util.function.Function;

@SuppressWarnings("unused")
public class Lambda {
	
	// () -> expression 
	// () -> { expression / multi-line }
	
	// Lambda syntax consist of three parts – list of parameters(), an arrow mark-> and a body {} .
	// Return type and possible list of exceptions that can be thrown are not explicitly mentioned in a lambda.
	// They are implicitly applied.
	
	public static void main(String args[]) {
		
		String hi = "Hi";
		
		// Old
		Comparator<Integer> iCompOld = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		}; 
		
		// using lambda
		Comparator<Integer> iComp = (Integer i1, Integer i2 ) -> {
			
			System.out.println(hi); // accessing local variable
			
			return i1 - i2;
			
		};
		
	}

}
