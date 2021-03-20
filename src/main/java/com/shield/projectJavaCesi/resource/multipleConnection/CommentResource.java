package com.shield.projectJavaCesi.resource.multipleConnection;

import com.shield.projectJavaCesi.resource.superbeing.*;
import com.shield.projectJavaCesi.resource.being.CivilForCommentRessource;
import com.shield.projectJavaCesi.resource.being.OrganisationForCommentRessource;
import com.shield.projectJavaCesi.resource.employee.EmployeeDepartmentResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeResource;
import com.shield.projectJavaCesi.resource.event.EventTypeResource;
import com.shield.projectJavaCesi.resource.event.IncidentResource;

public class CommentResource {
	public String comments;
	public SuperbeingForCommentResource superbeing;
	public CivilForCommentRessource civil;
	public OrganisationForCommentRessource organisation;
	// public AccessRoleForCommentResource accessRole;
	public EmployeeResource employee;
	public AbilityResource ability;
	public EmployeeDepartmentResource employeeDepartment;
	// public LocationResource location;
	// public MediaResource media;
	// public FeedbackResource feedback;
	// public LitigeResource litige;
	public EventTypeResource eventType;
	public IncidentResource incident;
	// public MissionResource mission;

}
