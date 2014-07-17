package com.test.ehcache.listener;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ListenerClient 
{
	private static ApplicationContext context;
    public static void main( String[] args ) throws InterruptedException
    {
    	 String DEFAULT_CONTEXT_FILE = "/ListenerContext.xml";   
         context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);  
         
        Cache cache = (Cache) context.getBean("ehCache");
        Element element = new Element("cache", "value"); 
 		cache.put(element);
 		
        Element element1 = new Element("cache1", "value1"); 
 		cache.put(element1);
 		
         System.out.println( cache.get("cacheKey") );
         System.out.println( cache.get("cache") );
         Thread.sleep(3000);
         System.out.println("get expired element");
         if(cache.get("cache") == null)
         {
        	 System.out.println("element is expiered, so you can't get it");
         }
         else
         {
        	 System.out.println(cache.get("cache"));
         }
         
         System.out.println("invoke evictExpiredElements to evict expired elements from cache");
         cache.evictExpiredElements();
         
        System.out.println("end");
    }
}
