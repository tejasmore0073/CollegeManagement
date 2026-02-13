package com.security.demo.dto;

import com.security.demo.model.Student;

public class StudentDTORequest {
	
	public StudentDTORequest(Integer roll, String name, String division, String year, String password, String email,
			Float marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.division = division;
		this.year = year;
		this.password = password;
		this.email = email;
		this.marks = marks;
	}
	public StudentDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer roll;
	private String name;
	private String division;
	private String year;
	private String password;
	private String email;
	private Float marks;
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
	public Float getMarks() {
		return marks;
	}
	public void setMarks(Float marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "StudentDTORequest [roll=" + roll + ", name=" + name + ", division=" + division + ", year=" + year
				+ ", password=" + password + ", email=" + email + ", marks=" + marks + "]";
	}
	
	
	public static Student toEntity(StudentDTORequest s) {
		
		Student temp=new Student();
		temp.setRoll(s.getRoll());
		temp.setName(s.getName());
		temp.setDivision(s.getDivision());
		temp.setEmail(s.getEmail());
		temp.setMarks(s.getMarks());
		temp.setPassword(s.getPassword());
		temp.setRole("Student");
		temp.setYear(s.getYear());
		temp.setUsername(s.getName()+s.getRoll());
		
		return temp;
	}
	

}
