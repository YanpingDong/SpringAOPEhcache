package com.test.ehcache.listener;


import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public class SimpleEhCacheOperation {
	private Cache cache;   
	
	public void setCache(Cache cache) {   
        this.cache = cache;   
    }   
	
	public Cache getCache()
	{
		return cache;
	}
	
	public SimpleEhCacheOperation(Cache cache) {
		this.cache = cache;
		Element element = new Element("cacheKey", "testvalue");   
        cache.put(element);   
	}
}
