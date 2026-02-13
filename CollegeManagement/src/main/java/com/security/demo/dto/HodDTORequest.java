package com.security.demo.dto;

import com.security.demo.model.Hod;

public class HodDTORequest {
	
	public HodDTORequest(Integer id, String name, String experience, String password, String email, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.experience = experience;
		this.password = password;
		this.email = email;
		this.dept = dept;
	}
	public HodDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private String name;
	private String experience;
	private String password;
	private String email;
	private String dept;
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
	@Override
	public String toString() {
		return "HodDTORequest [id=" + id + ", name=" + name + ", experience=" + experience + ", password=" + password
				+ ", email=" + email + ", dept=" + dept + "]";
	}
	
	
	public static Hod toEnity(HodDTORequest h) {
		
		Hod temp=new Hod();
		temp.setId(h.getId());
		temp.setName(h.getName());
		temp.setPassword(h.getPassword());
		temp.setEmail(h.getEmail());
		temp.setDept(h.getDept());
		temp.setExperience(h.getExperience());
		temp.setRole("Hod");
		temp.setUsername(h.getName()+h.getId());
		
		return temp;
	}

}
