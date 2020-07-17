package com.demo.java.threads.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {
	
	protected static int MAX_SIZE = 3;
	protected List<String> messages = new ArrayList<String>(MAX_SIZE);
	protected int taskCounter = 1;
	
	@Override
	public void run() {
		
		try {
			
			while(taskCounter < 20) {
				produce();
			}
			
			System.out.println("End of Consumer: " + Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private synchronized void  produce() throws InterruptedException {
			
		while(messages.size() == MAX_SIZE) {
			System.out.println("Producer Thread: " +Thread.currentThread().getName()+" is waiting as MAX_SIZE is reached.");
			wait();
			System.out.println("Producer Thread: " +Thread.currentThread().getName()+" got notified & is resuming task.");
		}
		
		String message = "Task-"+(taskCounter++);
		messages.add(message);
		
		System.out.println("Producer Thread: " +Thread.currentThread().getName() +" produced message: " + message);
		notify();
		
	}
	
	public synchronized String consume() throws InterruptedException {
		
		
		while(messages.size() == 0) {
			System.out.println("Consumer Thread: " +Thread.currentThread().getName()+" is waiting as there is no message.");
			wait();
			System.out.println("Consumer Thread: " +Thread.currentThread().getName()+" got notified & is resuming task.");
		}
		
		String message = messages.remove(0);
		notify();
		System.out.println("Consumer Thread: " +Thread.currentThread().getName() +" consumed data & notified.");
		return message;
	}

}
