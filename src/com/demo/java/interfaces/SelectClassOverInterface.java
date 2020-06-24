package com.demo.java.interfaces;

interface InterfaceOneN
{
    default void anyMethod()
    {
        System.out.println("Hi... From Interface One");
    }
}
 
interface InterfaceTwoN extends InterfaceOneN
{
    @Override
    default void anyMethod() 
    {
        System.out.println("Hi... From Interface Two");
    }
}
 
class ClassOneN implements InterfaceOneN, InterfaceTwoN
{
    @Override
    public void anyMethod() 
    {
        System.out.println("Hi... From Class One");
    }
}
 
public class SelectClassOverInterface extends ClassOneN implements InterfaceOneN, InterfaceTwoN
{
    public static void main(String[] args) 
    {
        new SelectClassOverInterface().anyMethod();
    }
}
	

