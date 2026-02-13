package com.security.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.dto.TeacherDTORequest;
import com.security.demo.dto.TeacherDTOResponse;
import com.security.demo.exception.InvalidId;
import com.security.demo.exception.InvalidMobileNumber;
import com.security.demo.model.Student;
import com.security.demo.model.Teacher;
import com.security.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository tr;
	
	@Override
	public void add(TeacherDTORequest teacher) {
		
		Integer id=teacher.getId();
		if(id>0) {
			if(tr.existsById(id))
				throw new InvalidId("Duplicate ID");
		}
		else
			throw new InvalidId("Invalid ID");
		
		String mob=teacher.getMob();
		if(mob.startsWith("+91"))
			mob=mob.substring(3);
		
		
		if(mob.length()==10) {
			if(mob.charAt(0)=='0'||mob.charAt(0)=='1'||mob.charAt(0)=='2'||mob.charAt(0)=='3'||mob.charAt(0)=='4'||mob.charAt(0)=='5')
				throw new InvalidMobileNumber("Not Start with 0,1,2,3,4,5");
			
			for(int i=0;i<mob.length();i++) {
				if(!Character.isDigit(mob.charAt(i)))
					throw new InvalidMobileNumber("Character Not Allowed");
			}
		}else
			throw new InvalidMobileNumber("Invalid Mobile Number");
		
		String email=teacher.getEmail();
		
		Teacher t=TeacherDTORequest.toEntity(teacher);
		
		tr.save(t);

	}

	@Override
	public List<TeacherDTOResponse> display() {
	
		List<Teacher>teacher=tr.findAll();
		return teacher.stream().map(TeacherDTOResponse::toDTO).toList();
	}

	@Override
	public TeacherDTOResponse search(Integer id) {
		
		if(tr.findById(id).isPresent()) {
			Teacher temp=tr.findById(id).get();
			return TeacherDTOResponse.toDTO(temp);
		}
		return null;
	}

	@Override
	public TeacherDTOResponse delete(Integer id) {
		// TODO Auto-generated method stub
		if(tr.findById(id).isPresent()) {
			Teacher temp=tr.findById(id).get();
			tr.deleteById(id);
			return TeacherDTOResponse.toDTO(temp);
		}
		return null;
	}

	@Override
	public TeacherDTOResponse update(Teacher teacher, Integer id) {
		// TODO Auto-generated method stub
		if(tr.findById(id).isPresent()) {
			Teacher temp=tr.findById(id).get();
			temp.setName(teacher.getName());
			temp.setMob(teacher.getMob());
			temp.setEmail(teacher.getEmail());
			temp.setPassword(teacher.getPassword());
			
			
			Teacher t=tr.save(temp);
			return TeacherDTOResponse.toDTO(t);
		}
		return null;
	}

}
