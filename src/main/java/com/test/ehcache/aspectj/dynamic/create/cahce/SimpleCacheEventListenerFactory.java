package com.test.ehcache.aspectj.dynamic.create.cahce;

import java.util.Properties;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

public class SimpleCacheEventListenerFactory extends CacheEventListenerFactory {

	@Override
	public CacheEventListener createCacheEventListener(Properties properties) {
	
		return (CacheEventListener) SimpleCacheEventListener.INSTANCE;
		
	}

}
