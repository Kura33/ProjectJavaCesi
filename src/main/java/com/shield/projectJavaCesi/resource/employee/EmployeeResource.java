package com.shield.projectJavaCesi.resource.employee;

import java.util.Date;
import com.shield.projectJavaCesi.resource.being.CivilForCommentRessource;
import com.shield.projectJavaCesi.resource.being.CivilForEmployeeRessource;
import com.shield.projectJavaCesi.resource.being.OrganisationForCommentRessource;

public class EmployeeResource {

	public String ref;
	public String function;
	public Date startDate;
	public Date endDate;
	public String contract;
	public String email;
	public CivilForEmployeeRessource civil;
	public EmployeeDepartmentResource department;
}
