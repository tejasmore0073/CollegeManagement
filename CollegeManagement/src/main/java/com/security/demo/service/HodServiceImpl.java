package com.security.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.dto.HodDTORequest;
import com.security.demo.dto.HodDTOResponse;
import com.security.demo.exception.InvalidEmail;
import com.security.demo.exception.InvalidId;
import com.security.demo.exception.InvalidName;
import com.security.demo.exception.InvalidPassword;
import com.security.demo.model.Hod;
import com.security.demo.repository.HodRepository;

@Service
public class HodServiceImpl implements HodService {

	@Autowired
	private HodRepository hr;

	@Override
	public void add(HodDTORequest hod) {

		Integer id = hod.getId();
		if (id > 0) {
			if (hr.existsById(id))
				throw new InvalidId("Duplicate ID");
		} else
			throw new InvalidId("Invalid ID");
		

		String name = hod.getName();

		if(name == null || !name.matches("[A-Za-z ]+")) {
		    throw new InvalidName("Invalid Name");
		}
		
		
		
		String pass = hod.getPassword();

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

		
		String email = hod.getEmail();

		if(email == null || 
		   !email.contains("@") || 
		   !email.contains(".") || 
		   email.startsWith("@") || 
		   email.endsWith(".")) {

		    throw new InvalidEmail("Invalid Email");
		}
		

		Hod h = HodDTORequest.toEnity(hod);
		hr.save(h);
	}

	@Override
	public List<HodDTOResponse> display() {

		List<Hod> hod = hr.findAll();
		return hod.stream().map(HodDTOResponse::toDTO).toList();
	}

	@Override
	public HodDTOResponse search(Integer id) {
		// TODO Auto-generated method stub
		if (hr.findById(id).isPresent()) {
			Hod temp = hr.findById(id).get();
			return HodDTOResponse.toDTO(temp);
		}
		return null;
	}

	@Override
	public HodDTOResponse delete(Integer id) {
		// TODO Auto-generated method stub
		if (hr.findById(id).isPresent()) {
			Hod temp = hr.findById(id).get();
			hr.deleteById(id);
			return HodDTOResponse.toDTO(temp);
		}
		return null;
	}

	@Override
	public HodDTOResponse update(Hod hod, Integer id) {
		if (hr.findById(id).isPresent()) {
			Hod temp = hr.findById(id).get();
			temp.setName(hod.getName());
			temp.setDept(hod.getDept());
			temp.setEmail(hod.getEmail());
			temp.setExperience(hod.getExperience());
			temp.setPassword(hod.getPassword());
			

			Hod h = hr.save(temp);
			return HodDTOResponse.toDTO(h);
		}
		return null;
	}

}
