package com.igate.jdbc;



import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JdbcClient {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.setProperty("spring.profiles.active", "oracle");
		ApplicationContext bf=new ClassPathXmlApplicationContext("testDao.xml");
		DataSource ds=(DataSource)bf.getBean("dataSource");
		System.out.println(ds.getConnection().getSchema());
		EmployeeDao eDao=(EmployeeDao)bf.getBean("employeeDao");
		
		//execute queryForInt
		int count=eDao.getCount();
		System.out.println("No of Employees in the table :"+count);
		
		
		String name=eDao.getEmployeeName(101);
		System.out.println("Name "+name);
		
		
		 
		//execute update (insert new record)
		/*int insert=eDao.insertRec(11111,"Shiv",55555.55);
		if(insert>0)
			System.out.println("Insert Success");
		else
			System.out.println("Insert Failed");
		
		
		
		
		//execute update (modify)
		int update=eDao.updateRec(106, "Shiv Kumar", 77777.77);
		if(update>0)
			System.out.println("Update Success");
		else
			System.out.println("Update Failed");
			
		*/
			
		
		//execute QueryForList
		List list=eDao.getAll();
		System.out.println("List of Records");
		for(Object emp:list)
		    System.out.println(emp);
		
		
		Employee employee=eDao.getEmpByEid(106);
		System.out.println("Employee Info");
		System.out.println("EID :"+employee.getEid());
		System.out.println("ENM :"+employee.getEnm());
		System.out.println("ESL :"+employee.getEsl());
		
		
		List<Employee> eList=eDao.getEmployeeList();
		System.out.println("List of Employees");
		for(Employee e:eList)
		    System.out.println(e.getEid()+" "+e.getEnm()+" "+e.getEsl());
		
		

	}

}
