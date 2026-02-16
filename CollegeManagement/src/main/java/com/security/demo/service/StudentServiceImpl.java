package com.security.demo.service;

import java.util.List;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.dto.StudentDTORequest;
import com.security.demo.dto.StudentDTOResponse;
import com.security.demo.exception.InvalidDivision;
import com.security.demo.exception.InvalidEmail;
import com.security.demo.exception.InvalidName;
import com.security.demo.exception.InvalidPassword;
import com.security.demo.exception.InvalidRoll;
import com.security.demo.model.Student;
import com.security.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository sr;

	@Override
	public void add(StudentDTORequest std) throws InvalidNameException {

		Integer roll = std.getRoll();
		if (roll > 0 && roll != null) {
			if (sr.existsById(roll))
				throw new InvalidRoll("Duplicate Roll No");
		} else {
			throw new InvalidRoll("Invalid Roll No");
		}
		
		String name = std.getName();

		if(name == null || !name.matches("[A-Za-z ]+")) {
		    throw new InvalidName("Invalid Name");
		}
		
		
		String pass = std.getPassword();

		if(pass.length() >= 6) {

		    boolean hasUpper = false;
		    boolean hasLower = false;
		    boolean hasDigit = false;
		    boolean hasSpecial = false;

		    for(int i = 0; i < pass.length(); i++) {

		        char ch = pass.charAt(i);

		        if(Character.isUpperCase(ch))
		            hasUpper = true;

		        else if(Character.isLowerCase(ch))
		            hasLower = true;

		        else if(Character.isDigit(ch))
		            hasDigit = true;

		        else
		            hasSpecial = true;
		    }

		    if(!(hasUpper && hasLower && hasDigit && hasSpecial))
		        throw new InvalidPassword(
		            "Password must contain Capital, Small, Number & Special Symbol"
		        );

		}
		else
		    throw new InvalidPassword("Password must be minimum 6 characters");




		String div = std.getDivision();
		if(div == null || 
				   !(div.equalsIgnoreCase("A") || 
				     div.equalsIgnoreCase("B") || 
				     div.equalsIgnoreCase("C"))) {

				    throw new InvalidDivision("Only Division A | B | C Allowed");
				}
		
		
		String email = std.getEmail();

		if(email == null || 
		   !email.contains("@") || 
		   !email.contains(".") || 
		   email.startsWith("@") || 
		   email.endsWith(".")) {

		    throw new InvalidEmail("Invalid Email");
		}

		
		
			

		Student st = StudentDTORequest.toEntity(std);

		sr.save(st);

	}

	@Override
	public List<StudentDTOResponse> display() {
		// TODO Auto-generated method stub

		List<Student> std = sr.findAll();

		return std.stream().map(StudentDTOResponse::toDTO).toList();
	}

	@Override
	public StudentDTOResponse search(Integer roll) {
		// TODO Auto-generated method stub
		if (sr.findById(roll).isPresent()) {
			Student temp = sr.findById(roll).get();
			return StudentDTOResponse.toDTO(temp);
		}
		return null;
	}

	@Override
	public StudentDTOResponse delete(Integer roll) {
		// TODO Auto-generated method stub
		if (sr.findById(roll).isPresent()) {
			Student temp = sr.findById(roll).get();
			sr.deleteById(roll);
			return StudentDTOResponse.toDTO(temp);
		}
		return null;
	}

	@Override
	public StudentDTOResponse update(Student std, Integer roll) {
		// TODO Auto-generated method stub
		if (sr.findById(roll).isPresent()) {
			Student temp = sr.findById(roll).get();
			temp.setName(std.getName());
			temp.setEmail(std.getEmail());
			temp.setDivision(std.getDivision());
			temp.setMarks(std.getMarks());
			temp.setPassword(std.getPassword());
			temp.setYear(std.getYear());

			Student ss = sr.save(temp);

			return StudentDTOResponse.toDTO(ss);
		}
		return null;
	}

}
