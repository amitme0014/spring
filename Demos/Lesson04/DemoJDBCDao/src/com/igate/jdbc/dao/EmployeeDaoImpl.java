package com.igate.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.igate.jdbc.bean.Employee;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	

	public int getCount()
	{
		int count=0;
		count=getJdbcTemplate().queryForObject("SELECT COUNT(*) FROM employees",Integer.class);
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
		return getJdbcTemplate().update(sql, params);
	}
	
	public int updateRec(int eid,String enm,double esl)
	{
	    String sql="UPDATE employees SET ename=?,esal=? WHERE eid=?";
	    Object[] params = new Object[]{enm,esl,eid};
	    int update=getJdbcTemplate().update(sql, params);
	    return update;
	}
	
	public List getAll()
	{
	   Object[] params=new Object[]{new Double(40000.00)};
       List list=getJdbcTemplate().queryForList("SELECT * from employees WHERE esal > ?",params);
       return list;
    }
	
	// to retrieve the an employee given eid
	public Employee getEmpByEid(int eid) {
		
	String sql = "SELECT eid,ename,esal FROM employees WHERE eid=?";
	Employee employee= (Employee) getJdbcTemplate().queryForObject(sql,new EmployeeRowMapper(),eid);
	return employee;
	
	}
	
    public List<Employee> getEmployeeList() 
    {
	   String sql = "SELECT * FROM employees WHERE esal>?";
	   List<Employee> eList =getJdbcTemplate().query(sql,new EmployeeRowMapper(),4000);
	   return eList;
	}

	

}
