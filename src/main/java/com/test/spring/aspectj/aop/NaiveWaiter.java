package com.test.spring.aspectj.aop;

public class NaiveWaiter {
	private String name = "naive waiter";
	/*
	 * No arguments constructor for AOP
	 */
	public NaiveWaiter(){}
	
	public NaiveWaiter(String name)
	{
		this.name = name;
	}
	public void greetTo(String clientName)
	{
		System.out.println("NaiveWaiter: greet to " + clientName  + name);
	}
	
	public void serveTo(String clientName)
	{
		System.out.println("NaiveWaiter: serveing " + clientName + name);
	}
}
