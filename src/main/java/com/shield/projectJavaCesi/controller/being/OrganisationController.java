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

import com.shield.projectJavaCesi.entity.being.Organisation;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.being.OrganisationResource;
import com.shield.projectJavaCesi.service.being.OrganisationService;

@RestController
@RequestMapping(path = "/organisation")
@Transactional
public class OrganisationController {
	@Autowired
	private OrganisationService service;

	@Autowired
	private EntityManager em;

	@GetMapping("/")
	public List<OrganisationResource> findAllOrganisations() {
		List<Organisation> organisations = service.getOrganisations();
		return Mapper.map(organisations, Mapper.organisationToOrganisationResource);
	}

	@GetMapping("/{id}")
	public OrganisationResource findOrganisationById(@PathVariable int id) {
		Organisation organisation = service.getOrganisationById(id);
		return Mapper.organisationToOrganisationResource.apply(organisation);
	}

	@PostMapping("/create")
	public List<OrganisationResource> addOrganisation(@RequestBody List<Organisation> organisation) {
		List<Organisation> organisations = service.saveOrganisation(organisation);
		em.flush();
		for (Organisation organisation1 : organisations) {

			em.refresh(organisation1);
		}
		return Mapper.map(organisations, Mapper.organisationToOrganisationResource);
	}

	@PutMapping("/update")
	public OrganisationResource updateOrganisation(@RequestBody Organisation organisation) {
		Organisation organisations = service.updateOrganisation(organisation);
		em.flush();
		em.refresh(organisations);

		return Mapper.organisationToOrganisationResource.apply(organisations);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOrganisationById(@PathVariable int id) {
		return service.deleteOrganisation(id);
	}

	@DeleteMapping("/delete-all")
	public String deleteOrganisations() {
		return service.deleteAllOrganisation();
	}
}
