package com.demo.java.threads;

class Notify {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final SharedThread st = new SharedThread();
		
		//Thread t1 will be waiting for lock of object
		
		Thread t1 = new Thread() {
			
			@Override
            public void run()
            {
                st.doWait();
            }
			
		};
		
		t1.start();
		
		// Thread t2 will be waiting for lock of object
		
		Thread t2 = new Thread() {
			
			@Override
            public void run()
            {
                st.doWait();
            }
			
		};
		
		t2.start();
		
		// Thread t3 will be waiting for lock of object
		Thread t3 = new Thread() {
			
			@Override
            public void run()
            {
                st.doWait();
            }
			
		};
		
		t3.start();
		
		try
        {
            Thread.sleep(2000);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
		
		//Thread t4 will notify only one thread which is waiting for lock of object 's'
        
        Thread t4 = new Thread() 
        {
            @Override
            public void run()
            {
                st.notifyOneThread();
            }
        };
         
        t4.start(); 
	}
}

class SharedThread {
	
	public synchronized void doWait() {
		
		Thread t = Thread.currentThread();
		
		System.out.println(t.getName()+" is releasing the lock and will wait");
        		
		try {
			t.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t.getName()+" is notified, acquired the lock & is running.");
		
	}
	
	public synchronized void notifyOneThread() {
		
		Thread t = Thread.currentThread();
		
		System.out.println(t.getName()+" is going to notify one thread.");
        		
		t.notify();
		//notify();
		
		System.out.println(t.getName()+" has notified one thread.");
		
	}
	
}

