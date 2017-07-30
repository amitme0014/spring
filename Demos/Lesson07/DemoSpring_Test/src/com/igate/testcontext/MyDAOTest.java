package com.igate.testcontext;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igate.jdbc.EmployeeDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("testDao.xml")
@ActiveProfiles("oracle")
public class MyDAOTest {
	@Autowired
	private EmployeeDao employeeDAO;

	@Test
	public void testSalary() {
System.out.println("in test class" + employeeDAO.getEmployeeName(1105));
Assert.assertNotNull(employeeDAO.getCount());
	}
	
	@Test
	public void testAllEmployee() {
		System.out.println("in test class"  );
		Assert.assertNotNull(employeeDAO.getAll());
	}
}
