package com.demo.java.jb.exercise;

import java.io.Externalizable;


interface A { }
interface B { }

public class TryOut2 {

	public static void main(String[] args) {
		
		printmyname("jack");
		
		//finalize

	}
	
	private int no = 10;

	private static void printmyname(String name) {
		
		//System.out.println(no);
		
		name = name + "Nelson";
				
				Runnable r = () -> {
					try {
						
						Thread.sleep(100);
						
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Welcome " + name);
				};
		
		
	}
	
	

}
