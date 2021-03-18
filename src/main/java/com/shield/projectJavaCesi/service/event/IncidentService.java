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
		if (incident.getRef() != null) {
			existingIncident.setRef(incident.getRef());
		}
		if (incident.getStartDate() != null) {
			existingIncident.setStartDate(incident.getStartDate());
		}
		existingIncident.setEndDate(incident.getEndDate());
		if (incident.isSolved() != null) {
			existingIncident.setSolved(incident.isSolved());
		}
		if (incident.isArchive() != null) {
			existingIncident.setArchive(incident.isArchive());
		}
		if (incident.getEventType() != null) {
			existingIncident.setEventType(incident.getEventType());
		}
		if (incident.getDangerousness() != null) {
			existingIncident.setDangerousness(incident.getDangerousness());
		}
		if (incident.getStatus() != null) {
			existingIncident.setStatus(incident.getStatus());
		}
		return repository.save(existingIncident);
	}

}
