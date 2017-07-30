package com.igate.testcontext;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igate.writer.Writer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"testBean.xml"})
public class MyTest {
	
	@Autowired
	private Writer writer;

	@Test
	public void createTest() {
		System.out.println("in test class");
		Assert.assertNotNull(writer.getNumber());
	}
	
	@Test
	public void createTest1() {
		System.out.println("in test class");
		Assert.assertEquals(100, writer.getNumber());
	}

}
