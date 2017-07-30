package com.igate.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.igate.jdbc.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getCount()
	{
		int count=0;
		count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employees",Integer.class);
		return count;
	}
	
	public String getEmployeeName(int eid)
	{
		String sql = "SELECT ename FROM employees WHERE eid=?";
		String name=getJdbcTemplate().queryForObject(sql,String.class,eid);
		return name;
	}
	
	public int insertRec(int eid,String enm,double esl)
	{
	    String sql="INSERT INTO employees VALUES(?,?,?)";   
		Object[] params=new Object[]{eid,enm,esl};
		return jdbcTemplate.update(sql, params);
	}
	
	public int updateRec(int eid,String enm,double esl)
	{
	    String sql="UPDATE employees SET ename=?,esal=? WHERE eid=?";
	    Object[] params = new Object[]{enm,esl,eid};
	    int update=jdbcTemplate.update(sql, params);
	    return update;
	}
	
	public List getAll()
	{
	   Object[] params=new Object[]{new Double(40000.00)};
       List list=jdbcTemplate.queryForList("SELECT * FROM employees WHERE esal > ?",params);
       return list;
    }
	
	// to retrieve the an employees given eid
	public Employee getEmpByEid(int eid) {
		
	String sql = "SELECT eid,ename,esal FROM employees WHERE eid=?";
	Employee employees= (Employee) jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(),eid);
	return employees;
	
	}
	
    public List<Employee> getEmployeeList() 
    {
	   String sql = "SELECT * FROM employees where esal>?";
	   List<Employee> eList =jdbcTemplate.query(sql,new EmployeeRowMapper(),4000);
	   return eList;
	}

	

}
