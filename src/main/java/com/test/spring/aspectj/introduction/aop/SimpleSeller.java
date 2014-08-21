package com.test.spring.aspectj.introduction.aop;

public class SimpleSeller implements Seller {

	@Override
	public void sell(String goods) {
		System.out.println(goods);
	}

}
