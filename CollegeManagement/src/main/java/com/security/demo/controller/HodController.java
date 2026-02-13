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

import com.security.demo.dto.HodDTORequest;
import com.security.demo.dto.HodDTOResponse;
import com.security.demo.model.Hod;
import com.security.demo.service.HodService;

@RestController
@RequestMapping("hod")
public class HodController {

	@Autowired
	private HodService hs;
	
	@PostMapping("add")
	public void add(@RequestBody HodDTORequest h) {
		
		hs.add(h);
	}
	
	@GetMapping("display")
	public List<HodDTOResponse>display(){
		return hs.display();
	}
	
	@DeleteMapping("delete/{id}")
	public HodDTOResponse delete(@PathVariable Integer id) {
		return hs.delete(id);
	}
	
	@PutMapping("update/{id}")
	public HodDTOResponse update(@RequestBody Hod hod,@PathVariable Integer id) {
		return hs.update(hod, id);
	}
	
	@GetMapping("search/{id}")
	public HodDTOResponse search(@PathVariable Integer id) {
		return hs.search(id);
	}
}
