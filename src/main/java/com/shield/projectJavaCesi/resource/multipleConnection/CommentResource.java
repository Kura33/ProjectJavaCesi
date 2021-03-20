package com.shield.projectJavaCesi.resource.multipleConnection;

import com.shield.projectJavaCesi.resource.SuperbeingResource;
import com.shield.projectJavaCesi.resource.being.CivilResource;
import com.shield.projectJavaCesi.resource.being.OrganisationResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeDepartmentResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeResource;
import com.shield.projectJavaCesi.resource.event.EventTypeResource;
import com.shield.projectJavaCesi.resource.event.IncidentResource;

public class CommentResource {
	public int id;
	public String comments;
	public SuperbeingResource superbeing;
	public CivilResource civil;
	public OrganisationResource organisation;
	// public AccessRoleResource accessRole;
	public EmployeeResource employee;
	// public AbilityResource ability;
	public EmployeeDepartmentResource employeeDepartment;
	// public LocationResource location;
	// public MediaResource media;
	// public FeedbackResource feedback;
	// public LitigeResource litige;
	public EventTypeResource eventType;
	public IncidentResource incident;
	// public MissionResource mission;

}
