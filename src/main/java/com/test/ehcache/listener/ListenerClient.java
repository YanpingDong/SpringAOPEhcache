package com.test.ehcache.listener;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ListenerClient 
{
	private static final Log logger = LogFactory.getLog(ListenerClient.class);
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
 		 logger.debug("get key of cacheKey and key of cache in echcache");
 		 logger.debug( cache.get("cacheKey") );//this key is puted by SimpleEhcheOperation
 		 logger.debug( cache.get("cache") );
 		 
         Thread.sleep(3000);
         
         logger.debug("get expired element");
         if(cache.get("cache") == null)
         {
        	 logger.debug("element is expiered, so you can't get it");
         }
         else
         {
        	 logger.debug(cache.get("cache"));
         }
         
         logger.debug("invoke evictExpiredElements method to evict expired elements from cache");
         cache.evictExpiredElements();
         
         System.out.println("end");
    }
}