package com.demo.java;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.script.ScriptEngine;

import java.lang.NullPointerException;
import java.text.SimpleDateFormat;
import java.lang.ClassNotFoundException;


public class Test {
	
	public void testMe(String name) {
		
		System.out.println("Welcome: " + name);
		//IntSummaryStatistics
		
	}
	
	public static void showSupplier(Supplier<String> name) {
		
		System.out.println("Welcome: " + name.get());
		
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
		
		
		Stream<String> stream1 = Stream.of("Mango", "Apple", "Banana");
		stream1.filter((fruit)-> {
			System.out.println("fruit = " + fruit);
			return true;
		}).forEach((fruit) -> {});
		
		List<Integer> il = new ArrayList<Integer>(3) {{ 
			add(40);
			add(30);
			add(50);
			add(30);
			add(20);
		}};
		
		ArrayList<Integer> collect2 = il.stream().skip(2).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("collect2 = " + collect2);
		
		ArrayList<Integer> collect = il.stream().filter(value -> value > 18).sorted()
		.sequential().map(Integer::new).distinct()
		.collect(Collectors.toCollection(ArrayList::new));
		
		System.out.println("collect = " + collect.toString());
		
		
		//printMyName("Jack");
		List<String> aa = new ArrayList<String>(3) {{ 
			add("A");
			add("B");
			add("C");
		}};
		
		String result = aa.stream().reduce("", String::concat);
		System.out.println("result = " + result);
		
		aa.stream().forEach((name) -> {
			showSupplier(() -> name);
			}
		);
		
		aa.forEach(System.out::println);
		
		Runnable r = () -> {System.out.println("Thread running"); };
		
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("-LocalDateTime--");
		System.out.println(LocalDateTime.now().toLocalTime());
		System.out.println("---");
		
		StringBuffer s = new StringBuffer();
		
		try {
			int a = 10/0;
			
		} catch( ArrayIndexOutOfBoundsException | ArithmeticException e) {
			//e = null;
			System.out.println(e);
		}
		
		System.out.println(Calendar.getInstance().getTime());
		System.out.println(OffsetDateTime.now());
		System.out.println(LocalDateTime.now());
		
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		
		try {
			
			//int c = Integer.parseInt(a)+Integer.parseInt(b);
			System.out.println("testing here....");
			//int c = Math.addExact(a,b);
			System.out.println(Math.addExact(a,b));
			
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}
		
		Function<String, Integer> lengthFun = (s2) -> s2.length();
		Function<Integer, Boolean> TestFun = (ii) -> ii < 10;
		Function<String, Boolean> mainFun = lengthFun.andThen(TestFun);
		
		System.out.println("Final result is: " + mainFun.apply("Java 8"));
		
		Consumer<String> consumer1 = Test::printMyName ;
		
		List<String> testList = new ArrayList<String>(3) {{ 
			add("Jack");
			add("Jill");
			add("Ram");
		}};
		
		System.out.println("last 0: ");
		testList.stream().forEach((name) -> shoSupplier(() -> name));
		
    }
	
	public static void shoSupplier(Supplier<String> name) {
		System.out.println("pprint= " + name.get());
	}
	
	public static void printOnly(String name) {
		System.out.println("pprint= " + name);
	}

	public static void printMyName(String name) {

		name = name + "Nelson";
		
		Runnable r = () -> {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//System.out.println("Welcome:" + name);
		};
		
		
		
	}

}
