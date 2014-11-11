package com.test.spring.aspectj.schema.aop;

public class NaiveWaiter {
	public void init()
	{
		
	}
	public void greetTo(String clientName)
	{
		System.out.println("NaiveWaiter: greet to " + clientName );
	}
	
	public void serveTo(String clientName)
	{
		System.out.println("NaiveWaiter: serveing " + clientName );
	}
}
