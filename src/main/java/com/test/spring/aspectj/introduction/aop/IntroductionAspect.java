package com.test.spring.aspectj.introduction.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class IntroductionAspect implements Seller{
	private String smile = "Smile to the guest ";
	
	public IntroductionAspect(){}
	
	public IntroductionAspect(String tmpStr)
	{
		smile=tmpStr;
	}
	
	@DeclareParents(value="com.test.spring.aspectj.introduction.aop.NaiveWaiter",
			defaultImpl=com.test.spring.aspectj.introduction.aop.IntroductionAspect.class)
	private Seller seller;

	@Override
	public void sell(String goods) {
		System.out.println(smile + goods);
	}
}
