package com.demo.java.datastructure;

public class ImplementHashMap {

	public static void main(String[] args) {


		MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();
		
		myHashMap.put("Test1", "Value1");
		myHashMap.put("Test2", "Value2");
		myHashMap.put("Test22", "Value3");
		myHashMap.put("Test12", "Value4");
		myHashMap.put("Test23", "Value5");
		myHashMap.put("Test24", "Value6");
		
		System.out.println(myHashMap.get("Test1"));
		System.out.println(myHashMap.get("Test12"));
		System.out.println(myHashMap.get("Test23"));

	}

}
