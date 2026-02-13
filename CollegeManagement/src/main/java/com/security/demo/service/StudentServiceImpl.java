package com.security.demo.service;

import java.util.List;

import javax.sound.sampled.ReverbType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.dto.StudentDTORequest;
import com.security.demo.dto.StudentDTOResponse;
import com.security.demo.model.Student;
import com.security.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {



	@Autowired
	private StudentRepository sr;

   
  
	
	@Override
	public void add(StudentDTORequest std) {
		// TODO Auto-generated method stub
		Student st=StudentDTORequest.toEntity(std);
		
		sr.save(st);

	}

	@Override
	public List<StudentDTOResponse> display() {
		// TODO Auto-generated method stub
		
		List<Student> std=sr.findAll();
				
		return std.stream().map(StudentDTOResponse::toDTO).toList();
	}

	@Override
	public StudentDTOResponse search(Integer roll) {
		// TODO Auto-generated method stub
		if(sr.findById(roll).isPresent()) {
			Student temp=sr.findById(roll).get();
			return StudentDTOResponse.toDTO(temp);
		}
		return null;
	}

	@Override
	public StudentDTOResponse delete(Integer roll) {
		// TODO Auto-generated method stub
		if(sr.findById(roll).isPresent()) {
			Student temp=sr.findById(roll).get();
			sr.deleteById(roll);
			return StudentDTOResponse.toDTO(temp);
		}
		return null;
	}

	@Override
	public StudentDTOResponse update(Student std, Integer roll) {
		// TODO Auto-generated method stub
		if(sr.findById(roll).isPresent()) {
			Student temp=sr.findById(roll).get();
			temp.setName(std.getName());
			temp.setEmail(std.getEmail());
			temp.setDivision(std.getDivision());
			temp.setMarks(std.getMarks());
			temp.setPassword(std.getPassword());
			temp.setYear(std.getYear());
			
			Student ss=sr.save(temp);
			
			return StudentDTOResponse.toDTO(ss);
		}
		return null;
	}

}
