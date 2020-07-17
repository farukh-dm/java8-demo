package com.demo.java.threads;

import java.util.ArrayList;
import java.util.List;

public class SynchronizationIssueResolution {
	
	public static void main(String args[]) throws InterruptedException {
			
		List<Character> valueList = new ArrayList<Character>();
		
		System.out.println("Main started >>>>>>>>");
	
		MessageThread t1 = new MessageThread("LOREM", valueList); // shared valueList
		MessageThread t2 = new MessageThread("IPSUM", valueList); // shared valueList
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Main completed >>>>>>>");

	}

}

class MessageThread extends Thread {
	
	private String value;
	private List<Character> valueList;
	
	public MessageThread(String value, List<Character> valueList) {
		super();
		this.value = value;
		this.valueList = valueList;
	}

	@Override
	public void run() {
		
		synchronized(valueList) {
			
			System.out.println("Current thread using is: " + Thread.currentThread().getName());
			
			for(int i=0; i<value.length(); i++) {
				
				this.valueList.add(value.charAt(i));
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(this.valueList);
	
		} //synchronized block
		
	}
	
}
