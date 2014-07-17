package com.test.spring.ltw.aspectj.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring.aspectj.schema.aop.NaiveWaiter;

public class TestLTWAspectjClient {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		String DEFAULT_CONTEXT_FILE = "LTWAspectJcontext.xml";   
        context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);   
        NaiveWaiter waiter =  context.getBean(NaiveWaiter.class);
        waiter.greetTo("LTWAspectJcontext");
        waiter.serveTo("LTWAspectJcontext");
	}

}
