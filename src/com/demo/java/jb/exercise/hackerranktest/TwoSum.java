package com.demo.java.jb.exercise.hackerranktest;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String args[]) {
		
		Integer[] matchedIndices = twoSum(8);
		
		if(matchedIndices != null) {

			System.out.println(matchedIndices[0]+", "+matchedIndices[1]);
			
		} else {
			System.out.println("No Match");
		}
		
	}
	
	public static Integer[] twoSum(Integer result) {
		
		Integer[] matchedIndices = null;
		Integer[] numbers = new Integer[] {1,3,5,7,9,11};
		
		Map<Integer, Integer> valueToIndexMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<numbers.length-1; i++) {
			
			Integer delta = result - numbers[i];
			
			if(valueToIndexMap.containsKey(delta)) {
				
				matchedIndices = new Integer[] {i, valueToIndexMap.get(delta)};
				break;
			
			} else {
				valueToIndexMap.put(numbers[i], i);
			}
		
		}
		
		return matchedIndices;
		
	}

}
