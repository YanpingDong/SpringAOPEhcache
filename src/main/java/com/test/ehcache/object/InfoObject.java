package com.test.ehcache.object;

import java.io.Serializable;

/*
 * 1. if you want put object to ehcache and want to use getValue to get this stored object 
 * the object must be implement Serializable interface or use getObjectValue to get object.
 * Read 2 for more getObjectValue detail
 * 2. if you don't implements Serializable interface and want to get stored object,
 * you can use getObjectValue function to get. but the Object cann't be overflow to disk,
 * so you must set overflowToDisk to false in echache.xml. if not ,will print error info 
 * "ERROR net.sf.ehcache.store.disk.DiskStorageFactory$DiskWriteTask.call(DiskStorageFactory.java:503)  
 *  net.sf.ehcache.store.disk.DiskStorageFactory$DiskWriteTask.call - Disk Write of infoObject failed: 
 *  java.io.NotSerializableException: com.test.ehcache.object.InfoObject"
 */
public class InfoObject implements Serializable{
	
	private static final long serialVersionUID = 608083140121562292L;
	private String name;
	private String age;
	public InfoObject(String name, String age)
	{
		this.name = name;
		this.age = age;
	}
	
	public void print()
	{
		System.out.println(this.name + " age is " + age);
	}
	
	@Override
	public String toString()
	{
		return this.name + " age is " + age;
	}
}
