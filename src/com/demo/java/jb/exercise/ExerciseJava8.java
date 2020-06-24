package com.demo.java.jb.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExerciseJava8 {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
			
			new Employee("Lorem", "Ipsum", 50),
			new Employee("Foo", "Bar", 30),
			new Employee("John", "Doe", 25),
			new Employee("Clacius", "Clay", 60)
			
		);
		
		//1. Sort all employee by their last name
		Collections.sort(employees, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		//2. List all employees
		System.out.println("2.");
		listAllWithCondition(employees, (emp) -> true);
		
		// 3. List all employees where age > 30
		System.out.println("3.");
		listAllWithCondition(employees, (emp) -> emp.getAge() > 30);
		
		// 4. List all employees where age <= 30
		System.out.println("4.");
		listAllWithCondition(employees, (emp) -> emp.getAge() <= 30);
		
	}
	
	public static void listAllWithCondition(List<Employee> employees, Condition condition) {
		for(Employee emp : employees) {
			if(condition.test(emp)) {
				System.out.println(emp);
			}
		}
		
	}

}
