package com.demo.java.jb.exercise;

interface A { }
interface B { }

interface C extends A, B { }

class CC implements A, C { }

class DD extends CC implements B { }

interface Z {
	
	// Interface does not extend Object class. still can override hashcode(), equals(), etc. 
	// This is because, as per Java specifications, for every interface which does not have direct super interfaces.
	// there is an implicit abstract and public method declared, for every public method in Object class,  
	@Override
	int hashCode();

	@Override
	boolean equals(Object obj); 
	
}

public class TryOut {

	public static void main(String[] args) {
		
		A a = null;
		
		// Interface does not extend Object class.
		a.equals(null); 
		a.hashCode();
		a.toString();

	}

}
