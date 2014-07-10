package com.test.spring.aop.ehcach;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ApplicationContext context;
	
    public static void main( String[] args )
    {
    	 String DEFAULT_CONTEXT_FILE = "/AppContext.xml";   
         context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);   
         VirtualDatabase testService = (VirtualDatabase)context.getBean("proxyVirtualDatabase");   
   
         System.out.println("1.1--第一次调用exist");   
         testService.exist();   
         System.out.println("1.2--第二次调用exist"); 
         testService.exist();
         
         System.out.println("2。1--第一次调用findData");   
         System.out.println(testService.findData());
         System.out.println("2。2--第二次调用findData"); 
         System.out.println(testService.findData());
         
         System.out.println("3。1--第一次调用findDataByArg");   
         System.out.println(testService.findDataByArg("first_invoke"));
         System.out.println("3。2--第二次调用findDataByArg"); 
         System.out.println(testService.findDataByArg("first_invoke"));
    }
}
