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

import com.security.demo.dto.TeacherDTORequest;
import com.security.demo.dto.TeacherDTOResponse;
import com.security.demo.model.Teacher;
import com.security.demo.service.TeacherService;

@RestController
@RequestMapping("teacher")
public class TeacherController {

	@Autowired
	private TeacherService ts;
	
	@PostMapping("add")
	public void add(@RequestBody TeacherDTORequest teacher) {
		
		ts.add(teacher);
	}
	
	@GetMapping("display")
	public List<TeacherDTOResponse>display(){
		return ts.display();
	}
	
	@DeleteMapping("delete/{id}")
	public TeacherDTOResponse delete(@PathVariable Integer id) {
		return ts.delete(id);
	}
	
	@PutMapping("update/{id}")
	public TeacherDTOResponse update(@RequestBody Teacher teacher,@PathVariable Integer id) {
		return ts.update(teacher, id);
	}
	
	@GetMapping("search/{id}")
	public TeacherDTOResponse search(@PathVariable Integer id) {
		return ts.search(id);
	}
}
