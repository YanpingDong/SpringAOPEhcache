package com.test.spring.aspectj.aop;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectjClient {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		NaiveWaiter target = new NaiveWaiter();
		
		AspectJProxyFactory factory = new AspectJProxyFactory();
	    factory.setTarget(target);
	    factory.addAspect(PreGreetingAspect.class);
	    NaiveWaiter proxy = factory.getProxy();
	    proxy.greetTo("clientName");
	    proxy.serveTo("clientName");
	    
	    System.out.println("====================================");
	    
	    String DEFAULT_CONTEXT_FILE = "/AspectJcontext.xml";   
        context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);   
	    NaiveWaiter proxyFromXML = (NaiveWaiter)context.getBean("waiter");
	    proxyFromXML.greetTo("clientNameFromXML");
	    proxyFromXML.serveTo("clientNameFromXML");
	}

}
