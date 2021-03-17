package com.shield.projectJavaCesi.service.event;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.repository.event.IIncidentRepository;

@Service
public class IncidentService {
	@Autowired
	private IIncidentRepository repository;

	public List<Incident> saveIncident(List<Incident> incidents) {
		return repository.saveAll(incidents);
	}

	public Incident getIncidentById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Incident> getIncidents() {
		return repository.findAll();
	}

	public String deleteIncident(int id) {
		repository.deleteById(id);
		return "Incident " + id + " deleted";
	}

	public String deleteAllIncident() {
		repository.deleteAll();
		return "All Incidents deleted";
	}

	public Incident updateIncident(Incident incident) {
		Incident existingIncident = (Incident) repository.findById(incident.getId()).orElse(null);
		if (existingIncident == null) {
			return null;
		}
		existingIncident.setRef(incident.getRef());
		existingIncident.setStartDate(incident.getStartDate());
		existingIncident.setEndDate(incident.getEndDate());
		existingIncident.setSolved(incident.isSolved());
		existingIncident.setArchive(incident.isArchive());
		existingIncident.setEventType(incident.getEventType());
		existingIncident.setDangerousness(incident.getDangerousness());
		existingIncident.setStatus(incident.getStatus());

		return repository.save(existingIncident);
	}

}
