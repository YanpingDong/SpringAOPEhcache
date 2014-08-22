package com.test.ehcache.aspectj.dynamic.create.cahce;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectjDynamicCreateCacheClient {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
	    
	    String DEFAULT_CONTEXT_FILE = "/AspectjDynamicCreateCacheContext.xml";   
        context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);   
        VirtualDatabase virtualDatabase11 = context.getBean("virtualDatabase1", VirtualDatabase.class);
        VirtualDatabase virtualDatabase22 = context.getBean("virtualDatabase2", VirtualDatabase.class);
	
        /*
         * test function by invoking exist function
         */
        virtualDatabase11.exist(); 
        virtualDatabase22.exist();
    
       String[] caches = CacheManager.getInstance().getCacheNames();
       int length = caches.length;
       System.out.println("================");
       for(int i = 0; i < length; i++)
       {
    	   System.out.println(caches[i]);
    	  
    	   Element element = CacheManager.getInstance().getEhcache(caches[i]).get("key");
    	   if(null != element)
    	       System.out.println("get element key in cache : " + element.getObjectKey());
    	   else
    		   System.out.println("The element already has been clear");
           
    	   CacheManager.getInstance().getEhcache(caches[i]).evictExpiredElements();
       }
	}

}
