package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entities.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	//Below annotation is required to inject auto created entityManager from entityManagerFactory
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.cg.dao.EmployeeRepository#save(com.cg.entities.Employee)
	 */
	@Override
	public Employee save(Employee employee) {

		entityManager.persist(employee);
		entityManager.flush();	//required to reflect changes on database
		
		return employee;
	}
	/* (non-Javadoc)
	 * @see com.cg.dao.EmployeeRepository#loadAll()
	 */
	@Override
	public List<Employee> loadAll() {
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}

}
