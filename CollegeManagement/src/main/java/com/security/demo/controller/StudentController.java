package com.security.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.dto.StudentDTORequest;
import com.security.demo.dto.StudentDTOResponse;
import com.security.demo.model.Student;
import com.security.demo.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService ss;
	
	@PostMapping("add")
	public void add(@RequestBody StudentDTORequest s)
	{
		ss.add(s);
	}
	
	@GetMapping("display")
	public List<StudentDTOResponse> display(){
		
		return ss.display();
	}
	
	@DeleteMapping("delete/{roll}")
	public StudentDTOResponse delete(@PathVariable Integer roll) {
		return ss.delete(roll);
	}
	
	@PutMapping("update/{roll}")
	public StudentDTOResponse update(@RequestBody Student std,@PathVariable Integer roll) {
		return ss.update(std, roll);
	}
	
	@GetMapping("search/{roll}")
	public StudentDTOResponse search(@PathVariable Integer roll) {
		return ss.search(roll);
	}
}
