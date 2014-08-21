package com.test.ehcache.aspectj.dynamic.create.cahce;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.CacheConfiguration.CacheEventListenerFactoryConfiguration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreDBOCacheAspect {	
    
	private Cache cache = null;
	
	public PreDBOCacheAspect(int maxElementsInMemory, boolean overflowToDisk, 
			boolean eternal, long timeToLiveSeconds, long timeToIdleSeconds)
	{
		/*
		 * cann't know how many cache will be create, so name is a issue. 
		 * the current method use object hoashCode as name.
		 */
		
		//register listener
		CacheEventListenerFactoryConfiguration factory = new CacheEventListenerFactoryConfiguration();
		factory.className("com.test.ehcache.aspectj.dynamic.create.cahce.SimpleCacheEventListenerFactory");
		
		 CacheConfiguration cacheConfiguration = new CacheConfiguration(String.valueOf(this.hashCode()), maxElementsInMemory)
        .overflowToDisk(overflowToDisk)
        .eternal(eternal)
        .timeToLiveSeconds(1)
        .timeToIdleSeconds(1)
        .cacheEventListenerFactory(factory);

		cache = new Cache(cacheConfiguration, null, null);

		CacheManager.create().addCache(cache);
	}
	
	@Before("execution(* exist(..))&&target(com.test.ehcache.aspectj.dynamic.create.cahce.VirtualDatabase)")
	public void beforeExist()
	{
		System.out.println("this object use " + cache.getName()  + " cache");
		
		//put element to trigger event of putting in listener
		String keyName = "key";
		
		Element element = new Element(keyName, "element");
		cache.put(element);
		
		//wait for element expire and then invoke evictExpiredElements to 
		//trigger event of Element Expired
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//cache.evictExpiredElements();
	}
}
