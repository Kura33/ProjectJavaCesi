package com.shield.projectJavaCesi.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.shield.projectJavaCesi.entity.being.Civil;
import com.shield.projectJavaCesi.entity.being.Organisation;
import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.entity.employee.EmployeeDepartment;
import com.shield.projectJavaCesi.entity.event.EventType;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.multipleConnection.Comment;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;
import com.shield.projectJavaCesi.resource.event.EventTypeResource;
import com.shield.projectJavaCesi.resource.event.IncidentResource;
import com.shield.projectJavaCesi.resource.multipleConnection.CommentResource;
import com.shield.projectJavaCesi.resource.SuperbeingResource;
import com.shield.projectJavaCesi.resource.being.CivilForCommentRessource;
import com.shield.projectJavaCesi.resource.being.CivilResource;
import com.shield.projectJavaCesi.resource.being.OrganisationForCommentRessource;
import com.shield.projectJavaCesi.resource.being.OrganisationResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeDepartmentResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeResource;

public class Mapper {

	public static <T, R> List<R> map(List<T> list, Function<T, R> func) {

		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(func.apply(t));
		}
		return result;
	}

	public static Function<EventType, EventTypeResource> eventTypeToEventTypeResource = (eventType) -> {
		EventTypeResource res = new EventTypeResource();
		if (eventType == null) {
			return null;
		}
		res.name = eventType.getName();
		return res;
	};

	public static Function<Incident, IncidentResource> incidentToIncidentResource = (incident) -> {
		if (incident == null) {
			return null;
		}
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

	public static Function<Civil, CivilResource> civilToCivilResource = (civil) -> {
		CivilResource res = new CivilResource();
		res.id = civil.getId();
		res.firstName = civil.getFirstname();
		res.lastName = civil.getLastname();
		res.socialSecurityNumber = civil.getSocialSecurityNumber();
		res.gender = civil.getGender();
		res.ref = civil.getRef();
		// res.organisation = civil.isOrganisation();
		res.malevolant = civil.isMalevolant();
		res.email = civil.getEmail();
		res.password = civil.getPassword();
		res.birthdate = civil.getBirthdate();
		res.deathdate = civil.getDeathdate();
		res.address = civil.getAddress();
		res.city = civil.getCity();
		res.state = civil.getState();
		res.zipcode = civil.getZipcode();
		res.coutry = civil.getCoutry();
		res.mobilePhone = civil.getMobilePhone();
		res.addedAt = civil.getAddedAt();
		res.updateAt = civil.getUpdatedAt();
		res.howManyDeclaredIncident = civil.getHowManyDeclaredIncident();
		res.victimOfHowManyMission = civil.getVictimOfHowManyMission();
		res.archive = civil.isArchive();
		return res;
	};
	public static Function<Civil, CivilForCommentRessource> civilForCommentToCivilForCommentResource = (civil) -> {
		CivilForCommentRessource res = new CivilForCommentRessource();
		res.firstName = civil.getFirstname();
		res.lastName = civil.getLastname();
		return res;
	};

	public static Function<Organisation, OrganisationResource> organisationToOrganisationResource = (organisation) -> {
		OrganisationResource res = new OrganisationResource();
		res.id = organisation.getId();
		res.name = organisation.getName();
		res.siret = organisation.getSiret();
		res.ref = organisation.getRef();
		// res.organisation = organisation.isOrganisation();
		res.malevolant = organisation.isMalevolant();
		res.email = organisation.getEmail();
		res.password = organisation.getPassword();
		res.birthdate = organisation.getBirthdate();
		res.deathdate = organisation.getDeathdate();
		res.address = organisation.getAddress();
		res.city = organisation.getCity();
		res.state = organisation.getState();
		res.zipcode = organisation.getZipcode();
		res.coutry = organisation.getCoutry();
		res.mobilePhone = organisation.getMobilePhone();
		res.addedAt = organisation.getAddedAt();
		res.updateAt = organisation.getUpdatedAt();
		res.howManyDeclaredIncident = organisation.getHowManyDeclaredIncident();
		res.victimOfHowManyMission = organisation.getVictimOfHowManyMission();
		res.archive = organisation.isArchive();
		return res;
	};
	public static Function<Organisation, OrganisationForCommentRessource> organisationForCommentToOrganisationForCommentResource = (organisation) -> {
		OrganisationForCommentRessource res = new OrganisationForCommentRessource();
		res.name = organisation.getName();
		return res;
	};


	public static Function<EmployeeDepartment, EmployeeDepartmentResource> employeeDepartmentToEmployeeDepartmentResource = (employeeDepartment) -> {
		if (employeeDepartment == null) {
			return null;
		}
		EmployeeDepartmentResource res = new EmployeeDepartmentResource();
		res.department = employeeDepartment.getDepartement();
		res.city = employeeDepartment.getCity();
		res.country = employeeDepartment.getCountry();
		return res;
	};

	public static Function<Employee, EmployeeResource> employeeToEmployeeResource = (employee) -> {
		if (employee == null) {
			return null;
		}
		EmployeeResource res = new EmployeeResource();
		res.id = employee.getId();
		res.ref = employee.getRef();
		res.function = employee.getFunction();
		res.startDate = employee.getStartDate();
		res.endDate = employee.getEndDate();
		res.archive = employee.isArchive();
		res.email = employee.getEmail();
		res.password = employee.getPassword();
		res.contract = employee.getContract();
		// res.being = Mapper.beingToBeingResource.apply(being.getBeing());
		res.department = Mapper.employeeDepartmentToEmployeeDepartmentResource.apply(employee.getEmployeeDepartment());
		return res;
	};

	public static Function<Comment, CommentResource> commentToCommentResource = (comment) -> {
		if (comment == null) {
			return null;}
			CommentResource res = new CommentResource();
			res.comments = comment.getComments();
			// res.superbeing =
			// Mapper.superbeingToSuperbeingResource.apply(comment.getSuperbeing());
			if (comment.getBeing() != null) {
				// check classname is either Civil or Organisation to display the right Being
				if (comment.getBeing().getClass().getName() == Civil.class.getName()) {
					res.civil = Mapper.civilForCommentToCivilForCommentResource.apply((Civil) comment.getBeing());
				} else {
					res.organisation = Mapper.organisationForCommentToOrganisationForCommentResource.apply((Organisation) comment.getBeing());
				}
			}
			// res.accessRole =
			// Mapper.accessRoleToAccessRoleResource.apply(comment.getAccessRole());
			if (comment.getEmployee() != null) {
			res.employee = Mapper.employeeToEmployeeResource.apply(comment.getEmployee());}
			// res.ability = Mapper.abilityToAbilityResource.apply(comment.getAbility());
			if (comment.getEmployeeDepartment() != null) {
			res.employeeDepartment = Mapper.employeeDepartmentToEmployeeDepartmentResource.apply(comment.getEmployeeDepartment());}
			// res.location =
			// Mapper.locationToLocationResource.apply(comment.getLocation());
			// res.media = Mapper.mediaToMediaResource.apply(comment.getMedia());
			// res.feedback =
			// Mapper.feedbackToFeedbackResource.apply(comment.getFeedback());
			// res.litige = Mapper.litigeToLitigeResource.apply(comment.getLitige());
			if (comment.getEventType() != null) {
			res.eventType = Mapper.eventTypeToEventTypeResource.apply(comment.getEventType());}
			if (comment.getIncident() != null) {
			res.incident = Mapper.incidentToIncidentResource.apply(comment.getIncident());}
			// res.mission = Mapper.missionToMissionResource.apply(comment.getMission());
			return res;
		};

}
