package com.test.spring.aspect.aop.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectjIOCClient {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
	    
	    String DEFAULT_CONTEXT_FILE = "/AspectjIOCContext.xml";   
        context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);   
	    NaiveWaiter proxyFromXML = (NaiveWaiter)context.getBean("waiter");
	    proxyFromXML.greetTo("clientNameFromXML");
	    proxyFromXML.serveTo("clientNameFromXML");
	}

}
