package com.demo.java.threads;

public class MultiThreadDemo {
	
	public static void main(String args[]) {
		
		System.out.println("Main started >>>>>>>>");
		
		Printer printer = new Printer();
		
		// Multiple thread sharing same printer object. So need to synchronize the object's access
		Thread t1 = new MyPrinterThread(printer, "Profile1.txt");
		Thread t2 = new MyPrinterThread(printer, "Profile2.txt");

		t1.start();
		
		// mark the method as synchronized or use join() as used below
		/*try {
			t1.join(); //wait for this thread to die.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		
		t2.start();
		
		System.out.println("Main completed >>>>>>>");
		
	}

}

class Printer {
	
	// Lock / synchronize the method 
	//public synchronized void print(int numOfCopies, String document) {
		
	public void print(int numOfCopies, String document) {
		
		String tname = Thread.currentThread().getName();
		
		for(int i=1; i<=numOfCopies; i++) {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread: "+tname+", Printing document : " + document + ", copy number : " + i);
		}
	}
	
}

class MyPrinterThread extends Thread {
	
	Printer printerRef;
	
	String document;
	
	MyPrinterThread() {
		
	}
	
	MyPrinterThread(Printer printer, String document) {
		this.printerRef = printer;
		this.document = document;
	}
	
	@Override
	public void run() {
		
		// lock the object OR lock the print() method of Printer
		synchronized (printerRef) {
		
		//(printerRef) {
			printerRef.print(10, document);
		}
		
	}
	
}

