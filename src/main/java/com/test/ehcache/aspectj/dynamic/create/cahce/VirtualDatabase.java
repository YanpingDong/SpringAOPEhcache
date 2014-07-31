package com.test.ehcache.aspectj.dynamic.create.cahce;

public class VirtualDatabase {
	
	public VirtualDatabase()
	{
		System.out.println("construct object");
	}
	
	public VirtualDatabase(String name)
	{
		System.out.println("use param to construct object ");
	}
	
	public String findData()
	{
		return "find data info";
	}
	
	public String findDataByArg(String arg)
	{
		return arg;
	}
	
	public Boolean exist()
	{
		return true;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(this.hashCode());
	}
}
