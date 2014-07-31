package com.test.ehcache.object;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EhCahceObjectClient 
{
	private static final Log logger = LogFactory.getLog(EhCahceObjectClient.class);
	private static ApplicationContext context;
    public static void main( String[] args ) throws InterruptedException
    {
    	 String DEFAULT_CONTEXT_FILE = "/EhcacheObjectContext.xml";   
         context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);  
         
         Cache cache = (Cache) context.getBean("ehCache");
         InfoObject infoObject = (InfoObject) context.getBean("infoObject");
         
         Element element = new Element("infoObject", infoObject); 
 		 cache.put(element);
 		
         ((InfoObject)cache.get("infoObject").getObjectValue()).print();
         System.out.println(cache.get("infoObject").getValue().toString());
         logger.debug("end");
        
    }
}