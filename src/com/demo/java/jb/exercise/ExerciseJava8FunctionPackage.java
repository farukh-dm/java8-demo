package com.demo.java.jb.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExerciseJava8FunctionPackage {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
			
			new Employee("Lorem", "Ipsum", 50),
			new Employee("Foo", "Bar", 30),
			new Employee("John", "Doe", 25),
			new Employee("Sam", "Car", 55),
			new Employee("Clacius", "Clay", 60)
			
		);
		
		//1. Sort all employee by their last name
		Collections.sort(employees, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		//2. List all employees
		System.out.println("2.");
		listAllWithCondition(employees, (emp) -> true);
		
		// 3. List all employees where age > 30
		System.out.println("3.");
		performWithCondition(employees, (emp) -> emp.getAge() > 30, (emp) -> System.out.println(emp.getFirstName()));
		
		// 4. List all employees where age <= 30 . 
		System.out.println("4.");
		performWithCondition(employees, (emp) -> emp.getAge() <= 30, (emp) -> System.out.println(emp.getFirstName() + " " + emp.getAge()));
		
		// 4. List all employees where age > 50 && age < 60. 
		System.out.println("5.");
		performWithCondition(
			employees, 
			(emp) -> emp.getAge() > 50 && emp.getAge() < 60, // Predicate
			(emp) -> {System.out.println(emp.getLastName());} // Consumer
		);
		
	}
	
	public static void performWithCondition(
		List<Employee> employees, 
		Predicate<Employee> predicate,
		Consumer<Employee> consumer) {
		
		for(Employee emp : employees) {
			if(predicate.test(emp)) {
				consumer.accept(emp);
			}
		}
		
	}
	
	public static void listAllWithCondition(List<Employee> employees, 
		Predicate<Employee> predicate) {
		
		for(Employee emp : employees) {
			if(predicate.test(emp)) {
				System.out.println(emp);
			}
		}
		
	}


}
