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
@RequestMapping(path = "/incident")
@Transactional
public class CivilController {
	@Autowired
	private CivilService service;

	@Autowired
	private EntityManager em;

//	@GetMapping("/")
//	public List<CivilResource> findAllCivils() {
//		List<Civil> incidents = service.getCivils();
//		return Mapper.map(incidents, Mapper.incidentToCivilResource);
//	}
//
//	@GetMapping("/{id}")
//	public CivilResource findCivilById(@PathVariable int id) {
//		Civil incident = service.getCivilById(id);
//		return Mapper.incidentToCivilResource.apply(incident);
//	}
//
//	@PostMapping("/create")
//	public List<CivilResource> addCivil(@RequestBody List<Civil> incident) {
//		List<Civil> incidents = service.saveCivil(incident);
//		em.flush();
//		for (Civil incident1 : incidents) {
//
//			em.refresh(incident1);
//		}
//		return Mapper.map(incidents, Mapper.incidentToCivilResource);
//	}
//
//	@PutMapping("/update")
//	public CivilResource updateCivil(@RequestBody Civil incident) {
//		Civil incidents = service.updateCivil(incident);
//		em.flush();
//		em.refresh(incidents);
//
//		return Mapper.incidentToCivilResource.apply(incidents);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public String deleteCivilById(@PathVariable int id) {
//		return service.deleteCivil(id);
//	}
//
//	@DeleteMapping("/delete-all")
//	public String deleteCivils() {
//		return service.deleteAllCivil();
//	}
}
