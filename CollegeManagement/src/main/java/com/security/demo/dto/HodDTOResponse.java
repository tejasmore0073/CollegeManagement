package com.security.demo.dto;

import com.security.demo.model.Hod;

public class HodDTOResponse {
	
	public HodDTOResponse(Integer id, String name, String experience, String email, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.experience = experience;
		this.email = email;
		this.dept = dept;
	}
	public HodDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private String name;
	private String experience;
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
		return "HodDTOResponse [id=" + id + ", name=" + name + ", experience=" + experience + ", email=" + email
				+ ", dept=" + dept + "]";
	}
	
	
	public static HodDTOResponse toDTO(Hod h) {
		HodDTOResponse temp=new HodDTOResponse();
		temp.setId(h.getId());
		temp.setName(h.getName());
		temp.setDept(h.getDept());
		temp.setEmail(h.getEmail());
		temp.setExperience(h.getExperience());
		
		return temp;
	}

}
