package com.security.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hod {
	
	@Id
	private Integer id;
	private String name;
	private String experience;
	private String username;
	private String password;
	private String email;
	private String dept;
	private String role;
	
	public Hod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hod(Integer id, String name, String experience, String username, String password, String email, String dept,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.experience = experience;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dept = dept;
		this.role = role;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Hod [id=" + id + ", name=" + name + ", experience=" + experience + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", dept=" + dept + ", role=" + role + "]";
	}
	
	
	
	
	
}
