package com.demo.java.threads;

public class BasicThread {
	
	public static void main(String args[]) {
		
		Thread t1 = new MyThread();
		
		Runnable t2 = new MyRunnable();
		
		Thread t3 = new Thread(t2);
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.setName("HighPriority Thread");
		
		t1.start(); // start a new thread
		t2.run();  // executes in the current thread
		t3.start(); // start a new thread
		
		String tname = Thread.currentThread().getName();
		for(int i=0; i<10; i++) {
			System.out.println(tname+" main, i :" + i);
		}
		
	}
	
}

class MyThread extends Thread {

	@Override
	public void run() {
		
		System.out.println("in run()");
		String tname = Thread.currentThread().getName();
		
		for(int i=0; i<10; i++) {
			System.out.println(tname+" MyThread, i :" + i);
		}
		
	}
	
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		
		System.out.println("in run()");
		String tname = Thread.currentThread().getName();
		
		for(int i=0; i<10; i++) {
			System.out.println(tname+" MyRunnable, i :" + i);
		}
		
	}
	
}


