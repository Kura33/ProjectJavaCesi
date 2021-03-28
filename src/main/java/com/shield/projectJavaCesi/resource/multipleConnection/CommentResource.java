package com.shield.projectJavaCesi.resource.multipleConnection;

import com.shield.projectJavaCesi.resource.being.AccessRoleResource;
import com.shield.projectJavaCesi.resource.superbeing.AbilityResource;
import com.shield.projectJavaCesi.resource.superbeing.SuperbeingForCommentResource;
import com.shield.projectJavaCesi.resource.being.CivilForCommentResource;
import com.shield.projectJavaCesi.resource.being.OrganisationForCommentResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeDepartmentResource;
import com.shield.projectJavaCesi.resource.employee.EmployeeResource;
import com.shield.projectJavaCesi.resource.event.EventTypeResource;
import com.shield.projectJavaCesi.resource.event.IncidentResource;

public class CommentResource {
    public Integer id;
	public String comments;
	public SuperbeingForCommentResource superbeing;
	public CivilForCommentResource civil;
	public OrganisationForCommentResource organisation;
	// public AccessRoleResource accessRole;
	public EmployeeResource employee;
	public AbilityResource ability;
	public EmployeeDepartmentResource employeeDepartment;
	// public LocationResource location;
	// public MediaResource media;
	// public FeedbackResource feedback;
	// public LitigeResource litige;
	public EventTypeResource eventType;
	public IncidentResource incident;
    public AccessRoleResource accessRole;
    // public MissionResource mission;


}
