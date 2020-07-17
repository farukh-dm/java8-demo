package com.demo.java.threads;

import java.util.ArrayList;
import java.util.List;

public class SynchronizationIssue {
	
	public static void main(String args[]) throws InterruptedException {
			
		List<Character> valueList = new ArrayList<Character>();
		
		System.out.println("Main started >>>>>>>>");
	
		StrThread t1 = new StrThread("LOREM", valueList); //common valueList shared by thread
		StrThread t2 = new StrThread("IPSUM", valueList); //common valueList shared by thread
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Main completed >>>>>>>");

	}

}

class StrThread extends Thread {
	
	private String value;
	private List<Character> valueList;
	
	public StrThread(String value, List<Character> valueList) {
		super();
		this.value = value;
		this.valueList = valueList;
	}

	@Override
	public void run() {
		
		for(int i=0; i<value.length(); i++) {
			
			this.valueList.add(value.charAt(i));
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(this.valueList);
		
	}
	
}
