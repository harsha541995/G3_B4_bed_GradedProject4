package com.gl.ems.employeemgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ems.employeemgmt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstNameContaining(String fname);

	List<Employee> findAllByOrderByFirstName();



	
}