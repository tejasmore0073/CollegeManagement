package com.security.demo.dto;

import com.security.demo.model.Teacher;

public class TeacherDTORequest {
	
	public TeacherDTORequest(Integer id, String name, String password, String email, String mob) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mob = mob;
	}
	public TeacherDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String mob;
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
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	@Override
	public String toString() {
		return "TeacherDTORequest [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", mob=" + mob + "]";
	}

	
	public static Teacher toEntity(TeacherDTORequest t) {
		
		Teacher temp=new Teacher();
		temp.setId(t.getId());
		temp.setName(t.getName());
		temp.setEmail(t.getEmail());
		temp.setMob(t.getMob());
		temp.setPassword(t.getPassword());
		temp.setRole("Teacher");
		temp.setUsername(t.getName()+t.getId());
		
		return temp;
	}

}
