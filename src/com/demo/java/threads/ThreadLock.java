package com.demo.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock {
	
	public static void main(String args[]) throws InterruptedException {
		
		List<Character> valueList = new ArrayList<Character>();
		
		System.out.println("Main started >>>>>>>>");
	
		LockDemoThread t1 = new LockDemoThread("LOREM", valueList); // shared valueList
		LockDemoThread t2 = new LockDemoThread("IPSUM", valueList); // shared valueList
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Main completed >>>>>>>");

	}

}

class LockDemoThread extends Thread {
	
	private String value;
	private List<Character> valueList; 
	private static Lock lockRef = new ReentrantLock();
	
	LockDemoThread(String value, List<Character> valueList) {
		super();
		this.value = value;
		this.valueList = valueList;
	}
	
	@Override
	public void run() {
		
		lockRef.lock();
		
		try {
			
			System.out.println("Executing thread : " + Thread.currentThread().getName());
			
			for(int i=0; i<value.length(); i++) {
				
				this.valueList.add(value.charAt(i));
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(this.valueList);
		
		} finally {
			lockRef.unlock();
			System.out.println("Lock released by thread : " + Thread.currentThread().getName());
		}
		
	}
	
}
