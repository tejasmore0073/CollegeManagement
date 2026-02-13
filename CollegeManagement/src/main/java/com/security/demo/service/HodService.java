package com.security.demo.service;

import java.util.List;

import com.security.demo.dto.HodDTORequest;
import com.security.demo.dto.HodDTOResponse;
import com.security.demo.model.Hod;

public interface HodService {

	void add(HodDTORequest hod);

	List<HodDTOResponse> display();

	HodDTOResponse search(Integer id);

	HodDTOResponse delete(Integer id);
	
	HodDTOResponse update(Hod hod , Integer id);

}
