package com.shield.projectJavaCesi.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.shield.projectJavaCesi.entity.event.EventType;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.resource.EventTypeResource;
import com.shield.projectJavaCesi.resource.IncidentResource;

public class Mapper {
	public static Function<Incident, IncidentResource> incidentToIncidentResource = (incident) -> {
		IncidentResource res = new IncidentResource();
		res.id = incident.getId();
		res.ref = incident.getRef();
		res.startDate = incident.getStartDate();
		res.endDate = incident.getEndDate();
		res.solved = incident.isSolved();
		res.dangerousness = incident.getDangerousness();
		res.archive = incident.isArchive();
		res.status = incident.getStatus();
		res.eventType = incident.getEventType().getName();
		return res;
	};

	public static Function<EventType, EventTypeResource> eventTypeToEventTypeResource = (eventType) -> {
		EventTypeResource res = new EventTypeResource();
		res.name = eventType.getName();
		return res;
	};

	public static <T, R> List<R> map(List<T> list, Function<T, R> func) {

		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(func.apply(t));
		}
		return result;

	}
}
