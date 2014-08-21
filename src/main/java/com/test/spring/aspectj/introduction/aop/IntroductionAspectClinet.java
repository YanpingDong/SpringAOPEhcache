package com.test.spring.aspectj.introduction.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class IntroductionAspectClinet {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
	    
	    String DEFAULT_CONTEXT_FILE = "/introductionAspectContext.xml";   
        context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);  
        NaiveWaiter waiter =  context.getBean(NaiveWaiter.class);
        waiter.greetTo("clientName");
        Seller seller = (Seller)waiter;
        seller.sell("goods");
	}

}
