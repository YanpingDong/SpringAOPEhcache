package com.test.spring.ltw.aspectj.aop;

public class NaiveWaiter{
	public void greetTo(String clientName)
	{
		System.out.println("NaiveWaiter: greet to " + clientName );
	}
	
	public void serveTo(String clientName)
	{
		System.out.println("NaiveWaiter: serveing " + clientName );
	}
}
