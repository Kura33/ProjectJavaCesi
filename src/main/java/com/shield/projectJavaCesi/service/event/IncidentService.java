package com.shield.projectJavaCesi.service.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shield.projectJavaCesi.entity.being.Being;
import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.entity.being.Organisation;
import com.shield.projectJavaCesi.entity.event.EventType;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.repository.being.ICivilRepository;
import com.shield.projectJavaCesi.repository.being.IOrganisationRepository;
import com.shield.projectJavaCesi.repository.event.IEventTypeRepository;
import com.shield.projectJavaCesi.repository.multipleConnection.ICommentRepository;
import com.shield.projectJavaCesi.repository.superbeing.ISuperbeingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.repository.event.IIncidentRepository;

@Service
public class IncidentService {
	@Autowired
	private IIncidentRepository repository;
	@Autowired
	private ICommentRepository commentRepository;
	@Autowired
	private ISuperbeingRepository superbeingRepository;
	@Autowired
	private ICivilRepository civilRepository;
	@Autowired
	private IOrganisationRepository organisationRepository;
	@Autowired
	private IEventTypeRepository eventTypeRepository;


	public List<Incident> saveIncident(List<Incident> incidents) {
		return repository.saveAll(incidents);
	}

	public List<Incident> saveIncidentAndRelations(List<Map<String, Object>> incidentAndRelations)
	{
		List<Incident> savedIncidents = new ArrayList<>();
		for (Map<String, Object> incidentAndRelation : incidentAndRelations) {
			EventType eventType = eventTypeRepository.save((EventType)incidentAndRelation.get("eventType"));
			Incident incident = (Incident) incidentAndRelation.get("incident");
			incident.setEventType(eventType);
			incident = repository.save(incident);
			savedIncidents.add(incident);
		}

		return savedIncidents;
	}

	public Map<String, Object> getIncidentById(int id) {
		Map<String, Object> result = new HashMap<>();
		result.put("incident", repository.findById(id).orElse(null));
		result.put("comments", commentRepository.findCommentsByIncidentId(id));
		result.put("superbeings", superbeingRepository.findSuperbeingsByIncidentId(id));
		result.put("civils", civilRepository.findCivilsByIncidentId(id));
		result.put("organisations", organisationRepository.findOrganisationsByIncidentId(id));

		return result;
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
