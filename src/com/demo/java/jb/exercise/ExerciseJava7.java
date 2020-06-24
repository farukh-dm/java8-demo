package com.demo.java.jb.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExerciseJava7 {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
			
			new Employee("Lorem", "Ipsum", 50),
			new Employee("Foo", "Bar", 30),
			new Employee("John", "Doe", 25),
			new Employee("Clacius", "Clay", 60)
			
		);
		
		//1. Sort all employee by their last name
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
			
		});
		
		//2. List all employees
		System.out.println("2.");
		listAll(employees);
		
		// 3. List all employees where age > 30
		System.out.println("3.");
		listAllWithAgeGt30(employees);
		
		// 4. List all employees where age <= 30 . Inline implementation / inner class
		System.out.println("4.");
		listAllWithCondition(employees, new Condition() {
			
			@Override
			public boolean test(Employee emp) {
				return emp.getAge() <= 30;
			}
		});
		
	}
	
	public static void listAllWithCondition(List<Employee> employees, Condition condition) {
		for(Employee emp : employees) {
			
			if(condition.test(emp)) {
				System.out.println(emp);
			}
		}
		
	}

	private static void listAllWithAgeGt30(List<Employee> employees) {
		
		for(Employee emp : employees) {
			
			if(emp.getAge() > 30) {
				System.out.println(emp);
			}
		}
		
	}

	private static void listAll(List<Employee> employees) {
		
		for(Employee emp : employees) {
		
			System.out.println(emp);
		}
		
	}

}
