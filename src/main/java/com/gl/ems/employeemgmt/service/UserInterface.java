package com.gl.ems.employeemgmt.service;
import java.util.List;

import com.gl.ems.employeemgmt.entity.User;


public interface UserInterface {

	public List <User> findAll();
	
	public User findById(int theId);
	
	public void save(User user);
	
	public void deleteById(int theId);

}
