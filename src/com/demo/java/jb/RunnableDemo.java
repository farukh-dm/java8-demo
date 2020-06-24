package com.demo.java.jb;

public class RunnableDemo {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Inside Runnable");
				System.out.println(Thread.currentThread().getName());
			}
			
		});
		
		//t.start();
		t.run();
		
		Runnable lambdaThread = () -> {
			System.out.println("Inside Runnable 2");
			System.out.println(Thread.currentThread().getName());
		};
		
		Thread t2 = new Thread(lambdaThread);
		t2.run();
		
		Thread t3 = new Thread(() -> {
			
			System.out.println("Inside Runnable 3");
			System.out.println(Thread.currentThread().getName());
		});
		t3.run();
		
		
	}

}
