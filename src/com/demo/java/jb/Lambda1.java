package com.demo.java.jb;

public class Lambda1 {
	
	public static void main(String[] args) {
		
		// Inline implementaion of interface => anonymous Inner Class 
		MyFirstLambda anonymousInnerClass = new MyFirstLambda() {
			
			@Override
			public void likeWelcomeFunction() {
				System.out.println("Welcome in anonymousInnerClass!");
			}
		};
		
		anonymousInnerClass.likeWelcomeFunction();
		
		// Below 2 have interface defined with only one method. This is not creating inner class.
		MyFirstLambda likeWelcomeFunc = () -> System.out.println("Welcome!");
		MySecondLambda doubleNumberFunc = (int num) -> num * 2;
		
		likeWelcomeFunc.likeWelcomeFunction();
		System.out.println(doubleNumberFunc.likedoubleNumberFunction(5));

		// Below 2 does not have interface defined
		/*
		 * addNumberFunction = (int a, int b) -> a + b; 
		 * divideNumberFunction = (int a, int b) -> { if(b == 0) return 0; return a/b; };
		 */
		
	}
	
}

interface MyFirstLambda {
	void likeWelcomeFunction();
}

interface MySecondLambda {
	int likedoubleNumberFunction(int num);
}
