package com.shield.projectJavaCesi.resource.employee;

import java.util.Date;

import com.shield.projectJavaCesi.resource.being.CivilForEmployeeResource;

public class EmployeeResource {
    public Integer id;
	public String ref;
	public String function;
	public Date startDate;
	public Date endDate;
	public String contract;
	public String email;
	public CivilForEmployeeResource civil;
	public EmployeeDepartmentResource department;
}
