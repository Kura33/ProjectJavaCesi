package com.shield.projectJavaCesi.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.shield.projectJavaCesi.entity.event.EventType;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.resource.event.EventTypeResource;
import com.shield.projectJavaCesi.resource.event.IncidentResource;
import com.shield.projectJavaCesi.resource.SuperbeingResource;

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
	
	public static Function<Superbeing, SuperbeingResource> superbeingToSuperbeingResource = (superbeing) -> {
		SuperbeingResource res = new SuperbeingResource();
		res.id = superbeing.getId();
		res.ref = superbeing.getRef();
		res.name = superbeing.getName();
		res.superhero = superbeing.isSuperhero();
		res.likability = superbeing.getLikability();
		res.active = superbeing.isActive();
		res.eventParticipatedIn = superbeing.getEventParticipatedIn();
		res.eventSucceeded = superbeing.getEventSucceeded();
		res.eventFailed = superbeing.getEventFailed();
		res.eventCaused = superbeing.getEventCaused();
		res.arrestNumber = superbeing.getArrestNumber();
		res.collateralDamageRisk = superbeing.getCollateralDamageRisk();
		res.dangerousness = superbeing.getDangerousness();
		res.discoveredAt = superbeing.getDiscoveredAt();
		res.treasonRisk = superbeing.getTreasonRisk();
		res.affiliated = superbeing.isAffiliated();
		res.archive = superbeing.isArchive();
		return res;
	};

	public static Function<EventType, EventTypeResource> eventTypeToEventTypeResource = (eventType) ->{
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
