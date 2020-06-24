package com.demo.java.jb;

public class MethodReference {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> printMessage() );
		t1.run();
		
		Thread t2 = new Thread(MethodReference::printMessage); //Method reference
		t2.run();

	}
	
	public static void printMessage() {
		
		System.out.println(Thread.currentThread().getName());
		
	}
	

}
