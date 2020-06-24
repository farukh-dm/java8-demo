package com.demo.java.jb;

import java.util.Arrays;
import java.util.List;

import com.demo.java.jb.exercise.Employee;

public class Stream1 {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
				
			new Employee("Lorem", "Ipsum", 50),
			new Employee("Foo", "Bar", 30),
			new Employee("John", "Doe", 25),
			new Employee("Clacius", "Clay", 60)
			
		);
		
		employees.stream()
		.filter((emp) -> emp.getAge() > 30)
		.forEach((emp) -> System.out.println(emp));
		
	}

}
