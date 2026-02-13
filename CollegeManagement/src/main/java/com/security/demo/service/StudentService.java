package com.security.demo.service;

import java.util.List;

import com.security.demo.dto.StudentDTORequest;
import com.security.demo.dto.StudentDTOResponse;
import com.security.demo.model.Student;

public interface StudentService {

	void add(StudentDTORequest std);

	List<StudentDTOResponse> display();

	StudentDTOResponse search(Integer roll);

	StudentDTOResponse delete(Integer roll);

	StudentDTOResponse update(Student std, Integer roll);
}
