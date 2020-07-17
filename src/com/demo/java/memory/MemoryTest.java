package com.demo.java.memory;

public class MemoryTest {
	
	static int i = 0;

	public static void main(String[] args) {

		if (i < 25) {
			i++;
			System.out.println(i);
			// This will cause out of memory issue for PermaGen Space in java version < 1.8
			main(new String[] { ("Test").intern() });
		}

	}

}
