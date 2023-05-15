package com.gl.ems.employeemgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.ems.employeemgmt.entity.Employee;
import com.gl.ems.employeemgmt.service.EmployeeService;
import com.gl.ems.employeemgmt.entity.User;
import com.gl.ems.employeemgmt.service.UserDetailsServiceImpl;
import com.gl.ems.employeemgmt.service.UserInterface;
import com.gl.ems.employeemgmt.repository.UserRepository;


import java.sql.*;




import java.security.Principal;
import java.util.List;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;



@Controller
@RequestMapping("/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String getEmployees(Model theModel)
	{
		List <Employee> employees = employeeService.findAll();
		theModel.addAttribute("Employees", employees);
		return "list-Employees";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAddingEmployees(Model theModel) 
	{
		
	Employee employee = new Employee();	
	theModel.addAttribute("Employee", employee);
	return "Employee-form";
	}

	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		
		Employee employee = employeeService.findById(theId);
		theModel.addAttribute("Employee", employee);
		return "Employee-form";
	}
	
	
	@RequestMapping("/save")
	public String saveStudent(@RequestParam("id") int id,
			@RequestParam("firstName") String fName, 
			@RequestParam("lastName") String lName, 
			@RequestParam("email") String email
			) {
		
		Employee theEmployee ;
		if(id != 0) {
			
			theEmployee = employeeService.findById(id);
			theEmployee.setFirstName(fName);
			theEmployee.setLastName(lName);
			theEmployee.setEmail(email);
			
		}else
		{
			theEmployee = new Employee(fName, lName, email);
		}
		
		employeeService.save(theEmployee);
		return "redirect:/employee/list";
		
	}
	
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("employeeId") int theId) {
employeeService.deleteById(theId);
return "redirect:/employee/list";

	}

	
	@RequestMapping("/search")
	public String listSearchedEmployees(Model themodel, @RequestParam("searchText") String text) {
       
		List <Employee> employees = employeeService.getEmployeeByFirstName(text);
//		List <Employee> employees = employeeService.findAll();
		
       
		themodel.addAttribute("Employees", employees);
		System.out.println(employeeService.getEmployeeByFirstName(text));
		return "Employee-search";}
		
		

	
	
	
	
	
	@RequestMapping("/showFormForAddUser")
	public String showFormForAddingUser() 
	{
		
//	User user = new User();	
//	theModel.addAttribute("User", user);
	return "User-form";
	}
	

	
	@RequestMapping("/saveUser")
    public String saveUser(
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			@RequestParam("role") String role 

    		) {
		
	   
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    password = encoder.encode(password);
	    
	
		
		
		String url = "jdbc:mysql://localhost:3306/employeemgmt";     
		String dbuser ="root";                                                  
		String dbpassword = "Dabidi@192";
		
		

//	     
//	     
             try {
//
//			//1. Create a connection
			Connection myConn = DriverManager.getConnection(url,dbuser,dbpassword);
//			
//			//2. Create a statement
			Statement myStmt = myConn.createStatement();
//			
//			
			PreparedStatement pstmt = myConn.prepareStatement("INSERT INTO `users`(password,username,role) VALUES (?, ?, ?)");
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			pstmt.setString(3, role);
//
//			//3. Execute Query
			pstmt.executeUpdate();
//		
//		
//         //4. Close connection
			myConn.close();
		}
//
		catch(Exception e){
			e.printStackTrace();
		}
//        
     
             
             
		return "redirect:/employee/list";

	}
	
	
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("mymsg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("mymsg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
	
	
	
	
}
