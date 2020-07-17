package com.demo.java.jb;

import java.util.function.Consumer;

public class ClosureOrLocalVariableAccess {

	public static void main(String[] args) {
		
		int a = 10; // They are effectively final as they are read in. Java7 will force it to be Final.
		
		printSomething(
			20, 
			(num) -> { 
				System.out.println(num + a); // Compiler allows that, you can access/read.
				// But you cannot edit/update, as it is effectively final
				// a = 1; // This will give compile error
				
			}
		);

	}

	private static void printSomething(Integer i, Consumer<Integer> consumer) {
		
		consumer.accept(i);
		
	}

}
