package com.test.ehcache.listener;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

public class SimpleCacheEventListener implements CacheEventListener {

	public static final CacheEventListener INSTANCE = new SimpleCacheEventListener();
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementEvicted(Ehcache arg0, Element arg1) {
		System.out.println("notify element evicted: key is " + arg1.getKey() + " | " +arg1.toString() );		
	}

	@Override
	public void notifyElementExpired(Ehcache arg0, Element arg1) {
		System.out.println("notify element expired: key is " + arg1.getKey() + " | " +arg1.toString()+ " | "
				+ arg1.getCreationTime() + " | " + arg1.getExpirationTime());
	}

	@Override
	public void notifyElementPut(Ehcache arg0, Element arg1)
			throws CacheException {
		System.out.println("notify element put");
		
	}

	@Override
	public void notifyElementRemoved(Ehcache arg0, Element arg1)
			throws CacheException {
		System.out.println("notify element Removed");
		
	}

	@Override
	public void notifyElementUpdated(Ehcache arg0, Element arg1)
			throws CacheException {
		System.out.println("notify element Updated");
		
	}

	@Override
	public void notifyRemoveAll(Ehcache arg0) {
		System.out.println("notify element RemoveAll");
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return new CloneNotSupportedException("Singleton instance");	
	}
}
