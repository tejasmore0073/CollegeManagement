package com.security.demo.service;

import java.util.List;

import com.security.demo.dto.TeacherDTORequest;
import com.security.demo.dto.TeacherDTOResponse;
import com.security.demo.model.Teacher;

public interface TeacherService {
	
	void add(TeacherDTORequest teacher);
	
	List<TeacherDTOResponse>display();
	
	TeacherDTOResponse search(Integer id);
	
	TeacherDTOResponse delete(Integer id);
	
	TeacherDTOResponse update(Teacher teacher,Integer id);

}
