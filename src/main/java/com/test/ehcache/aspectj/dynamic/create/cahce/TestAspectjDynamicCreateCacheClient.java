package com.test.ehcache.aspectj.dynamic.create.cahce;

import net.sf.ehcache.CacheManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectjDynamicCreateCacheClient {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
	    
	    String DEFAULT_CONTEXT_FILE = "/AspectjDynamicCreateCacheContext.xml";   
        context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);   
        VirtualDatabase virtualDatabase11 = context.getBean("virtualDatabase1", VirtualDatabase.class);
        VirtualDatabase virtualDatabase22 = context.getBean("virtualDatabase2", VirtualDatabase.class);
	
        virtualDatabase11.exist();
        virtualDatabase11.exist();
        
        virtualDatabase22.exist();
        virtualDatabase22.exist();
       String[] caches = CacheManager.create().getCacheNames();
       int length = caches.length;
       System.out.println("================");
       for(int i = 0; i < length; i++)
    	   System.out.println(caches[i]);
	}

}
