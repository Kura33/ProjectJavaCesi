package com.shield.projectJavaCesi.resource.employee;

import java.util.Date;

public class EmployeeResource {
	public Integer id;
	public String ref;
	public String function;
	public Date startDate;
	public Date endDate;
	public Boolean active;
	public String contract;
	public Boolean archive;
	public String email;
	public String password;
	// public BeingResource being;
	public EmployeeDepartmentResource department;
}
