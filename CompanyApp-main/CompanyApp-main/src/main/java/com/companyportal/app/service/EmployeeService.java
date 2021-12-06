package com.companyportal.app.service;

import java.util.ArrayList;
import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeService {

	public void saveEmployeeData(Employee employee);

	public List<Employee> getEmployeesData();
	
	public void delete(int id);
	public Employee getEmployeeById(int id);
	public void update(Employee e);

}
