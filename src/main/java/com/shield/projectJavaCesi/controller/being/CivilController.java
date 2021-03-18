package com.shield.projectJavaCesi.controller.being;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.being.CivilResource;
import com.shield.projectJavaCesi.service.being.CivilService;

@RestController
@RequestMapping(path = "/civil")
@Transactional
public class CivilController {
	@Autowired
	private CivilService service;

	@Autowired
	private EntityManager em;

//	@GetMapping("/")
//	public List<CivilResource> findAllCivils() {
//		List<Civil> civils = service.getCivils();
//		return Mapper.map(civils, Mapper.civilToCivilResource);
//	}

//	@GetMapping("/{id}")
//	public CivilResource findCivilById(@PathVariable int id) {
//		Civil civil = service.getCivilById(id);
//		return Mapper.civilToCivilResource.apply(civil);
//	}

//	@PostMapping("/create")
//	public List<CivilResource> addCivil(@RequestBody List<Civil> civil) {
//		List<Civil> civils = service.saveCivil(civil);
//		em.flush();
//		for (Civil civil1 : civils) {
//
//			em.refresh(civil1);
//		}
//		return Mapper.map(civils, Mapper.civilToCivilResource);
//	}

//	@PutMapping("/update")
//	public CivilResource updateCivil(@RequestBody Civil civil) {
//		Civil civils = service.updateCivil(civil);
//		em.flush();
//		em.refresh(civils);
//
//		return Mapper.civilToCivilResource.apply(civils);
//	}

	@DeleteMapping("/delete/{id}")
	public String deleteCivilById(@PathVariable int id) {
		return service.deleteCivil(id);
	}

	@DeleteMapping("/delete-all")
	public String deleteCivils() {
		return service.deleteAllCivil();
	}
}
