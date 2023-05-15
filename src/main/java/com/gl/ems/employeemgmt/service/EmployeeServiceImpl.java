package com.gl.ems.employeemgmt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.ems.employeemgmt.entity.Employee;
import com.gl.ems.employeemgmt.repository.EmployeeRepository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;


@Repository
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
    EmployeeRepository employeeRepository;
	

	
	@Override
	@Transactional
	public List<Employee> findAll() {
				List <Employee> employees = employeeRepository.findAllByOrderByFirstName();
				
				return employees;

	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(theId).get();
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
		
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String fname) {
	
		return employeeRepository.findByFirstNameContaining(fname);
	}

}
