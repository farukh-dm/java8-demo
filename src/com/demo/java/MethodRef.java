package com.demo.java;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

class A {
	
}

interface B {
	
}

interface E {
	
}

interface F extends B, E {
	
}

@SuppressWarnings("unused")
public class MethodRef {
	
	static int x = 1;
	
	public static void main(String args[]) {
		
		int a[] = {1,2,3,4};
		System.out.println(a instanceof Object);
		
		int b[][] = {{2,3,4}, {3,4}};
		System.out.println(a[3] == b[0][2]);
		
		
		for(int x = 0;x < 5;x++) {
			System.out.println(x);
		}
		
		String ss = "Java";
		ss.concat(" 6");
		ss.replace("6", "7");
		System.out.println(ss);
		
		class Company {
			
		    String name;
		    
		    Company() {
		    	
		    	super();
		    	this.name = "Test";
		    	
		    }
		     
		    public Company(String name) 
		    {
		        this.name = name;
		    }
		     
		    public String getName()
		    {
		        return name;
		    }
		}
		
		// 1. Method reference to static method
		Function<String, Integer> lambdaFunction = (String str) -> { 
			return Integer.parseInt(str); 
		};
		System.out.println(lambdaFunction.apply("12"));
		
		//Calling parseInt() method using method reference
        Function<String, Integer> referenceFunction = Integer::parseInt;
        System.out.println(referenceFunction.apply("12"));
        
        //------------------------
        
        // 2. Method reference to instance method (ClassName::MethodName)
        Function<String, String> lambdaFunction2 = (String s) -> s.toLowerCase();
        System.out.println(lambdaFunction2.apply("JAVA"));
         
        //Calling toLowerCase() method using method reference
         
        Function<String, String> referenceFunction2 = String::toLowerCase;
        System.out.println(referenceFunction2.apply("JAVA"));
        
        //------------------------
        
        // 3. Method reference to instance method (ReferenceVariable::MethodName)        
        Company c = new Company("My_Company");
        
        //Calling getName() of c using lambda
         
        Supplier<String> lambdaSupplier = () -> c.getName();
        System.out.println(lambdaSupplier.get());
         
        //Calling getName() of c using method reference
         
        Supplier<String> referenceSupplier = c::getName;
        System.out.println(referenceSupplier.get());
        
        // -----------------------------
        
        // 4. Constructor References
        Supplier<Company> lambdaSupplier1 = () -> new Company();
        System.out.println(lambdaSupplier1.get().getName());
         
        //Creating objects using constructor references
         
        Supplier<Company> referenceSupplier1 = Company::new;
        System.out.println(referenceSupplier1.get().getName());
		
	}
	
}
