package com.demo.java.jb;

import java.util.Arrays;
import java.util.List;

import com.demo.java.jb.exercise.Employee;

public class CollectionForEach {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
			
			new Employee("Lorem", "Ipsum", 50),
			new Employee("Foo", "Bar", 30),
			new Employee("John", "Doe", 25),
			new Employee("Clacius", "Clay", 60)
			
		);
		
		employees.forEach((emp) -> System.out.println(emp));
		System.out.println("------");
		employees.forEach(System.out::println);
		

	}

}
