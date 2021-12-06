package com.companyportal.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	@Override
	public void saveEmployeeData(Employee employee) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesData() {
		List<Employee> empList=new ArrayList<Employee>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		empList=session.createQuery("from Employee").list();
		session.getTransaction().commit();
		session.close();
		return empList;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee emp=session.load(Employee.class, id);
		if(emp !=null)
		{
			session.delete(emp);
		}
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee emp=session.get(Employee.class, id);
		session.getTransaction().commit();
		session.close();
		return emp;
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		session.close();
		
		
	}

	

	

}
