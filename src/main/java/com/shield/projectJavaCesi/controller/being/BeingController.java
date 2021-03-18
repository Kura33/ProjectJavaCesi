package com.shield.projectJavaCesi.controller.being;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.service.being.BeingService;

@RestController
@RequestMapping(path = "/being")
public class BeingController {
	
	@Autowired
	private BeingService service;
	
	@PostMapping("/create")
	public List<Being> addBeings(@RequestBody List<Being> beings){
		return service.saveBeings(beings);
	}
	
	@GetMapping("/{id}")
	public Being findBeingById(@PathVariable int id){
		return service.getBeingById(id);
	}
	
	@GetMapping("/")
	public List<Being> findAllBeing(){
		return service.getBeings();
	}

}
