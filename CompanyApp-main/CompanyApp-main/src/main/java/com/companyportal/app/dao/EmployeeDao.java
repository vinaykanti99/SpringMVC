package com.companyportal.app.dao;


import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeDao {

	void saveEmployeeData(Employee employee);

	List<Employee> getEmployeesData();
	
	void delete(int id);
	Employee getEmployeeById(int id);
	
	void update(Employee e);
	

}
