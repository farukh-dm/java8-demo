package com.demo.java.threads.producerconsumer;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		
		Producer producer = new Producer();
		producer.setName("Producer-1");
		producer.start();
		
		Consumer consumer1 = new Consumer(producer);
		consumer1.setName("Consumer-1");
		consumer1.start();
		
		Consumer consumer2 = new Consumer(producer);
		consumer2.setName("Consumer-2");
		consumer2.start();

	}

}
