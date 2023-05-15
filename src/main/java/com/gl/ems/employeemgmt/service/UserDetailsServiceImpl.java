package com.gl.ems.employeemgmt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.gl.ems.employeemgmt.entity.Employee;
import com.gl.ems.employeemgmt.entity.User;
import com.gl.ems.employeemgmt.repository.UserRepository;
import com.gl.ems.employeemgmt.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService, UserInterface {

	@Autowired
	private UserRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByUserName(username);
		
		if(user==null) {
			
			throw new UsernameNotFoundException("User could not be found");
		}
		
		return new MyUserDetails(user);
	}

	





	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List <User> users = userRepository.findAll();
		return users;
	}



	@Override
	public User findById(int theId) {
		// TODO Auto-generated method stub
		return userRepository.findById(theId).get();
	}



	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(theId);	
	}

	
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	

	
	
}
