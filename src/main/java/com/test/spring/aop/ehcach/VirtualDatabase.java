package com.test.spring.aop.ehcach;

public class VirtualDatabase {
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
}
