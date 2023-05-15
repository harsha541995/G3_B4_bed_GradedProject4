package com.gl.ems.employeemgmt.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="users")
@Data
public class User {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;	

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="role")
	private String role;
	
	
//	@Column(name="role")
//	private String role;
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return role;
	}

	

	public void setRoles(String role) {
		this.role = role;
	}	
	
	
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(
//		name = "users_roles",
//		joinColumns = @JoinColumn(name="user_id"),
//		inverseJoinColumns = @JoinColumn(name="role_id")
//	)
	
//	private List <Role> roles = new ArrayList<Role>();


//	public List<Role> getRoles() {
//		return roles;
//	}


//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	
	
	public User( String password, String username, String role) {
		super();
		
	
		this.username = username;
		this.password = password;
		this.role  = role;
	}


	public User() {
		super();
	}
	

	
	}




