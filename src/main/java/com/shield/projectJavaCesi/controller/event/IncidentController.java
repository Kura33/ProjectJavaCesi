package com.shield.projectJavaCesi.controller.event;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.mapper.Mapper;
import com.shield.projectJavaCesi.resource.IncidentResource;
import com.shield.projectJavaCesi.service.event.IncidentService;

@RestController
@RequestMapping(path = "/incident")
public class IncidentController {
	@Autowired
	private IncidentService service;

	@GetMapping("/")
	public List<IncidentResource> findAllIncidents() {
		List<Incident> incidents = service.getIncidents();
		return Mapper.map(incidents, Mapper.incidentToIncidentResource);
	}

	@GetMapping("/{id}")
	public IncidentResource findIncidentById(@PathVariable int id) {
		Incident incident = service.getIncidentById(id);
		return Mapper.incidentToIncidentResource.apply(incident);
	}

	@PostMapping("/create")
	public List<IncidentResource> addIncident(@RequestBody List<Incident> incident) {
		List<Incident> incidents = service.saveIncident(incident);
		return Mapper.map(incidents, Mapper.incidentToIncidentResource);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteIncidentById(@PathVariable int id) {
		return service.deleteIncident(id);
	}

	@DeleteMapping("/delete-all")
	public String deleteIncidents() {
		return service.deleteAllIncident();
	}
}
