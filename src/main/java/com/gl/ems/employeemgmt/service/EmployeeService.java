package com.gl.ems.employeemgmt.service;

import com.gl.ems.employeemgmt.entity.Employee;

//import antlr.collections.List;

import java.util.List;

public interface EmployeeService {

	public List <Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee employee);
	
	public void deleteById(int theId);
	
	public List<Employee> getEmployeeByFirstName(String fname);
	
//	public List<Employee> getEmployeeByFirstName(String fname);

	
}
