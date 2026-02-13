package com.security.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.dto.HodDTORequest;
import com.security.demo.dto.HodDTOResponse;
import com.security.demo.exception.InvalidId;
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
