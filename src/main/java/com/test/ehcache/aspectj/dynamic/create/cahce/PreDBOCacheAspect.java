package com.test.ehcache.aspectj.dynamic.create.cahce;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

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
		 * there use object hoashCode as name.
		 */
		cache = new Cache(String.valueOf(this.hashCode()), maxElementsInMemory,
				overflowToDisk, eternal, timeToLiveSeconds, timeToIdleSeconds);
		CacheManager.create().addCache(cache);
	}
	
	@Before("execution(* exist(..))&&target(com.test.ehcache.aspectj.dynamic.create.cahce.VirtualDatabase)")
	public void beforeExist()
	{
		System.out.println("this object use " + cache.getName()  + " cache");
	}
}
