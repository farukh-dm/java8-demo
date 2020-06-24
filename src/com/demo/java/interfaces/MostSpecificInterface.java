package com.demo.java.interfaces;

interface InterfaceOne
{
    default void anyMethod()
    {
        System.out.println("Hi... From Interface One");
    }
}
 
interface InterfaceTwo extends InterfaceOne
{
    @Override
    default void anyMethod() 
    {
        System.out.println("Hi... From Interface Two");
    }
}
 
public class MostSpecificInterface implements InterfaceOne, InterfaceTwo {

	public static void main(String[] args) {
		new MostSpecificInterface().anyMethod();

	}

}
