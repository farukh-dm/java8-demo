package com.demo.java.threads.producerconsumer;

public class Consumer extends Thread {
	
	private Producer producer;
	
	public Consumer(Producer producer) {
        this.producer = producer;
    }
	
	@Override
	public void run() {
		
		while(producer.taskCounter <= 20 && producer.messages.size() > 0) {
			
			try {
				
				String message = producer.consume();
				System.out.println("Consumed by: " + Thread.currentThread().getName() + ", message: " + message);
                Thread.sleep(500);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} //while
		
		System.out.println("End of Consumer: " + Thread.currentThread().getName());
		
	}

}
