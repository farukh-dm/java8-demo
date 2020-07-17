package com.demo.java.threads;

public class MultiThreadJoinDemo {
	
	public static void main(String args[]) throws InterruptedException {
		
		System.out.println("Main started >>>>>>>>");
		
		XPrinter xPrinter = new XPrinter();
	
		// Multiple thread sharing same printer object. So need to synchronize the object's access
		MyXPrinterThread t2 = new MyXPrinterThread(xPrinter, "Profile2.txt");

		t2.start();
		
		//1. Either wait for a strict 3 seconds, before terminating thread 
		// Thread.sleep(3000);
		
		//OR
		// 2. For 3 seconds try to check between some fractions of seconds, if the task is complete.
		// As sometimes, the thread might get completed before 3 seconds.
		int maxSleep = 3000;
		int slept = 0;
		while(slept < maxSleep) {
			
			System.out.println("Sleeping for 300. Already slept for " + slept);
			Thread.sleep(300);
			slept = slept+300;
			
			if(!t2.isAlive()) {
				System.out.println("Thread was completed in "+ slept/1000 +" seconds. Max sleep time was: " + maxSleep/1000 + " seconds.");
				System.exit(0);
			}
			
		}
		
		if(t2.isAlive()) {
			System.out.println("Thread is still running after maxSleep: " + maxSleep/1000 + " seconds. Trying for graceful termination.");
			t2.setExitFlag(Boolean.TRUE);
			t2.join(); // to terminate the thread
		}		
		
		System.out.println("is thread alive: "+t2.isAlive());
		System.out.println("Main completed >>>>>>>");
		
		System.exit(0);
		
	}

}

class XPrinter {
	
	public void print(int numOfCopies, String document, MyXPrinterThread myXPrinterThread) {
		
		String tname = Thread.currentThread().getName();
		
		for(int i=1; i<=numOfCopies; i++) {
			
			// graceful way to stop thread execution
			if(myXPrinterThread.exitFlag) {
				break;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread: "+tname+", Printing document : " + document + ", copy number : " + i);
		}
		
	}
	
}

class MyXPrinterThread extends Thread {
	
	XPrinter printerRef;
	String document;
	boolean exitFlag = Boolean.FALSE;
	
	public void setExitFlag(boolean exitFlag) {
		this.exitFlag = exitFlag;
	}

	MyXPrinterThread(XPrinter xPrinter, String document) {
		this.printerRef = xPrinter;
		this.document = document;
	}
	
	@Override
	public void run() {
		printerRef.print(50, document, this);
		System.out.println("Marking run() completed.");
	}
	
}

