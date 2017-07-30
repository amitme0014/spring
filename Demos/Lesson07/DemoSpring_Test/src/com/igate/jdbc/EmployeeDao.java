package com.igate.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}

	public int getCount() {
		int count = 0;
		count = jdbcTemplate
				.queryForObject("SELECT count(*) FROM employees",Integer.class);
		return count;
	}

	public String getEmployeeName(int eid) {
		String sql = "SELECT ename FROM employees WHERE eid=?";
		String name = getJdbcTemplate().queryForObject(sql, String.class,
				eid);
		return name;
	}

	public int insertRec(int eid, String enm, double esl) {
		String sql = "INSERT INTO employees VALUES(?,?)";
		Object[] params = new Object[] { eid, enm, esl };
		return jdbcTemplate.update(sql, params);
	}

	public int updateRec(int eid, String enm, double esl) {
		String sql = "UPDATE employees SET ename=?,esal=? WHERE eid=?";
		Object[] params = new Object[] { enm, esl, eid };
		int update = jdbcTemplate.update(sql, params);
		return update;
	}

	public List getAll() {
		Object[] params = new Object[] { new Double(40000.00) };
		List list = jdbcTemplate.queryForList(
				"SELECT * FROM employees WHERE esal > ?", params);
		return list;
	}

	// to retrieve the an employee given eid
	public Employee getEmpByEid(int eid) {

		String sql = "SELECT eid,ename,esal FROM employees WHERE eid=?";

		RowMapper mapper = new RowMapper() {
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee e = new Employee();
				e.setEid(rs.getInt(1));
				e.setEnm(rs.getString(2));
				e.setEsl(rs.getDouble(3));
				System.out.println(rowNum);
				return e;
			}

		};

		Employee employee = (Employee) jdbcTemplate.queryForObject(sql,
				mapper, eid);
		return employee;

	}

	public List<Employee> getEmployeeList() {
		String sql = "SELECT * FROM employees";
		List<Employee> eList = jdbcTemplate.query(sql,
				new EmployeeRowMapper());
		return eList;
	}

}
