package com.demo.java.datastructure;

public class MyEntryNode<K, V> {
	
	int hash;
	MyEntryNode<K, V> next;
	K key = null;
	V value;
	
	public MyEntryNode(int hash, K key, V value, MyEntryNode<K, V> next) {
		super();
		this.hash = hash;
		this.next = next;
		this.value = value;
		this.key = key;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public MyEntryNode<K, V> getNext() {
		return next;
	}

	public void setNext(MyEntryNode<K, V> next) {
		this.next = next;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	
}
