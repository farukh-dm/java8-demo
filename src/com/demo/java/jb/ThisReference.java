package com.demo.java.jb;

public class ThisReference {

	public static void main(String[] args) {
		
		// 1. Anonymous inner class
		DemoI instance1 = new DemoI() {
			
			@Override
			public void doSomething() {
				
				System.out.println("Anonymous inner class#doSomething.");
				
				// "this" is allowed here, because an object of anonymous inner class is created &
				// "this" refer to object of anonymous inner class.
				System.out.println(this);
				
			}
			
			public String toString() {
				return "Anonymous inner class#toString";
			}
		};
		
		instance1.doSomething();
		
		// 2. Lambda. "this" can't be called from static method.
		DemoI lambda1 = () -> {
			
			System.out.println("lambda1#doSomething.");
			
			// "this" is NOT allowed here, because an "this" refer to context of 
			// object in which lambda is executed.
			// "this" cannot be called from static method
			// System.out.println(this); // This will give compile time error
			
		};
		
		lambda1.doSomething();
		
		// 3. Lambda. using "this" from instance method.
		ThisReference thisReferenceObj = new ThisReference();
		
		thisReferenceObj.thisTest();

	}
	
	public void thisTest() {
		
		DemoI lambda = () -> {
			System.out.println("thisTest lambda#doSomething.");
			
			// "this' is allowed if lambda is used in instance method.
			// "this" refers to object where in lambda is getting executed.
			System.out.println(this);
		};
		
		lambda.doSomething();
		
	}

	@Override
	public String toString() {
		return "ThisReference []";
	}
	
}

interface DemoI {
	
	void doSomething();
}
