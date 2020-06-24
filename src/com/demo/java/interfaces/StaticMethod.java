package com.demo.java.interfaces;

interface InterfaceWithDefaultAndStaticMethod
{
    void abstractMethod();           //Abstract Method
     
    default void defaultMethod()
    {
        System.out.println("It is a default method");
    }
     
    static void staticMethod()
    {
        System.out.println("It is a static method");
    }
}

public class StaticMethod implements InterfaceWithDefaultAndStaticMethod
{
    @Override
    public void abstractMethod() 
    {
        System.out.println("Abstract Method implemented");
    }
     
    //No need to implement defaultMethod()
     
    //Can't implement staticMethod()

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
