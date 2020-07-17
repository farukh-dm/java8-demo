package com.demo.java.datastructure;

public class MyHashMap<K, V> {
	
	private final static int DEFAULT_CAPACITY = 16;
	
	private MyEntryNode<K, V>[] buckets;

	private int capacity;

	private int size = 0;
	
	MyHashMap() {
		this(DEFAULT_CAPACITY);
	}
	
	MyHashMap(int capacity) {
		
		this.capacity = capacity;
		this.buckets = new MyEntryNode[this.capacity];
		
	}
	
	public int getSize() {
		return this.getSize();
	}
	
	public int getIndex(K key) {
		
		int index = Math.abs(key.hashCode() % this.capacity);
		System.out.println(key + "index is : " + index);
		
		return index;
		
	}
	
	public void put(K key, V value) {
		
		int indexOrHash = this.getIndex(key);
		
		MyEntryNode<K, V> newNode = new MyEntryNode<K, V>(indexOrHash, key, value, null);
		
		MyEntryNode<K, V> currentNode = this.buckets[indexOrHash];
		
		// Check for collision. Check if there is already some node present at index.
		if(currentNode != null) {
			
			do {
				
				//override if existing key
				if(currentNode.getKey().equals(key)) {
					currentNode.setValue(value);
					return;
				
				} else if(currentNode.getNext() != null) {
					
					currentNode = currentNode.getNext();
					
				} else {
					currentNode.next = newNode;
					size++;
					return;
				}
				
			} while(currentNode.getNext() != null);
			
			
		} else {	

			// put a new MyEntryNode at index position in the array this.buckets
			this.buckets[indexOrHash] = newNode;
			size++;
			
		}
		
	}
	
	public V get(K key) {
		
		V value = null;
		MyEntryNode<K, V> currentNode = null;
		
		int index = this.getIndex(key);
		
		if(index < capacity) {
			
			currentNode = this.buckets[index];
			
			 while (currentNode != null) {
		        if (currentNode.key.equals(key)) {
		            return currentNode.value;
		        }
		        currentNode = currentNode.next;
		    }
		}
		
		return value;
		
	}

}
