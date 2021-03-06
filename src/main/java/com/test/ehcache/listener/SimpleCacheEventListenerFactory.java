package com.test.ehcache.listener;

import java.util.Properties;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

public class SimpleCacheEventListenerFactory extends CacheEventListenerFactory {

	@Override
	public CacheEventListener createCacheEventListener(Properties properties) {
		CacheEventListener listener = null;
		String beanName = properties.getProperty("bean");
		System.out.println("creat listener " + beanName);
		if( beanName == null )
		{
			System.out.println("don't find bean name");
			throw new IllegalArgumentException("don't find bean name");
		}
		
		listener = (CacheEventListener) SpringContextHelper.getBean(beanName);
		if( listener == null )
		{
			System.out.println("can't get " + beanName +", it's null");
		}
		else
		{
			System.out.println("create listener " + SpringContextHelper.getBean(beanName).toString());
		}
		
		return (CacheEventListener) listener;
		//return SimpleCacheEventListener.INSTANCE;
		
	}

}
