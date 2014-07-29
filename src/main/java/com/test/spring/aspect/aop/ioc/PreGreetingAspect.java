package com.test.spring.aspect.aop.ioc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Aspect
public class PreGreetingAspect {	

	@Autowired
	@Qualifier(value="beInjectedObject2PreGreetingAspect")
	private BeInjectedObject2PreGreetingAspect beInjectedObject2PreGreetingAspect;
	
	@Before("execution(* greetTo(..))")
	public void beforeGreeting()
	{
		beInjectedObject2PreGreetingAspect.myPrint();
		System.out.println("How are you");
	}
}
