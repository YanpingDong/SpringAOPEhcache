package com.test.spring.aspectj.schema.aop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/SchemaAspectJcontext.xml"})
public class NaiveWaiterTest {

	@Autowired
	@Qualifier(value="waiter")
	private NaiveWaiter naiverWaiter;
	
	@Test
	public void testGreetTo() {
		naiverWaiter.greetTo("clientName");
	}

	@Test
	public void testServeTo() {
		naiverWaiter.serveTo("clientName");
	}

}
