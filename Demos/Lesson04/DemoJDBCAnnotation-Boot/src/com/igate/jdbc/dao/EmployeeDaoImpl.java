package com.igate.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.jdbc.bean.Employee;

@Repository("dao")
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired
	private DataSource myDataSource;
	@PostConstruct
	private void initialize() {
	setDataSource(myDataSource);
	}
	
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
       List list=getJdbcTemplate().queryForList("SELECT * FROM employees WHERE esal > ?",params);
       return list;
    }
	
	// to retrieve the an employee given eid
	public Employee getEmpByEid(int eid) {
		Employee emp=null;
	int count=getJdbcTemplate().queryForObject("SELECT COUNT(*) FROM employees WHERE eid=?", Integer.class,eid);
	if(count>0)
	{
	String sql = "SELECT eid,ename,esal FROM employees WHERE eid=?";
	 emp= (Employee) getJdbcTemplate().queryForObject(sql,new EmployeeRowMapper(),eid);
	}
	
		
	return emp;
	
	}
	
    public List<Employee> getEmployeeList() 
    {
	   String sql = "SELECT * FROM employees WHERE esal>?";
	   List<Employee> eList =getJdbcTemplate().query(sql,new EmployeeRowMapper(),4000);
	   return eList;
	}


}
