package com.test.spring.aspectj.schema.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSchemaAspectjClient {
private static ApplicationContext context;
	
	public static void main(String[] args) {
		    
	    String DEFAULT_CONTEXT_FILE = "/SchemaAspectJcontext.xml";   
        context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);   
	    NaiveWaiter proxyFromXML = (NaiveWaiter)context.getBean("waiter");
	    proxyFromXML.greetTo("clientNameFromXML");
	    proxyFromXML.serveTo("clientNameFromXML");
	}
}
