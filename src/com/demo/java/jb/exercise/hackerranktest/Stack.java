package com.demo.java.jb.exercise.hackerranktest;

public class Stack {
	
	int top;
	int capacity;
	int[] arr;
	
	public Stack() {
		super();
	}

	public Stack(int capacity) {
		super();
		this.capacity = capacity;
		this.top = -1;
		arr = new int[this.capacity];
	}

	public static void main(String args[]) throws Exception {
		
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
		
	}
	
	public void push(int num) throws Exception {
		
		if(this.isFull()) {
			throw new Exception("Stack is full");
		} 
		
		arr[++top] = num;
		
	}
	
	public Integer pop() throws Exception {
		
		if(this.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		
		return arr[top--];
		
	}

	private boolean isEmpty() {
		return this.top == -1;
	}

	private boolean isFull() {
		return this.top == (this.capacity -1);
	}
	
	public Integer peek() throws Exception {
		
		if(this.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		
		return arr[top];
		
	}

}

