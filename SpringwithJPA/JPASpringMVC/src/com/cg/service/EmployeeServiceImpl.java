package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.EmployeeRepository;
import com.cg.entities.Employee;

@Service
@Transactional	//This annotation will make automatic transaction management  
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	/* (non-Javadoc)
	 * @see com.cg.service.EmployeeService#save(com.cg.entities.Employee)
	 */
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/* (non-Javadoc)
	 * @see com.cg.service.EmployeeService#loadAll()
	 */
	@Override
	public List<Employee> loadAll() {
		return employeeRepository.loadAll();
	}
}
