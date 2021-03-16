package com.shield.projectJavaCesi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shield.projectJavaCesi.entity.event.Event;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.repository.IEventRepository;

@Service
public class EventService {
	@Autowired
	private IEventRepository repository;

	public Event saveEvent(Event event) {
		return repository.save(event);
	}

	public List<Event> saveEvents(List<Event> events) {
		return repository.saveAll(events);
	}

	public Event getEventById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Event> getEvents() {
		return repository.findAll();
	}

	public String deleteEvent(int id) {
		repository.deleteById(id);
		return "Event " + id + " deleted";
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
