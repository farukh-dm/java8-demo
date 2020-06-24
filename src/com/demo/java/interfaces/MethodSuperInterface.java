package com.demo.java.interfaces;
import java.io.Externalizable;
import java.io.Serializable;
import java.util.Optional;
import java.lang.String;
import java.util.Date;
import java.time.LocalDateTime;

interface InterfaceOneM
{
    default void anyMethod()
    {
        System.out.println("Hi... From Interface One");
        
    }
    
}

class Abc implements InterfaceOne {

	private static int no = 10;
	
	public static void main(String args[]) {
		System.err.println(no);
		
	}
	
}
 
interface InterfaceTwoM 
{
    default void anyMethod() 
    {
        System.out.println("Hi... From Interface Two");
    }
}

public class MethodSuperInterface implements InterfaceOneM, InterfaceTwoM {
	
	@Override 
	
    public void anyMethod()
    {
        InterfaceOneM.super.anyMethod();
        InterfaceTwoM.super.anyMethod();
    }
	
	public static void main(String[] args) {

		new MethodSuperInterface().anyMethod();

	}

}
