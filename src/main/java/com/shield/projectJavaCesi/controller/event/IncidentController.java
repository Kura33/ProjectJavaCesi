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

import com.shield.projectJavaCesi.entity.event.Event;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.service.event.IncidentService;

@RestController
@RequestMapping(path = "/incident")
public class IncidentController {
	@Autowired
	private IncidentService service;

	@GetMapping("/")
	public List<Incident> findAllIncidents() {
		return service.getIncidents();
	}

	@PostMapping("/create")
	public List<Incident> addIncident(@RequestBody List<Incident> incident) {
		return service.saveIncident(incident);
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
