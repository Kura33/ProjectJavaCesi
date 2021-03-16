package com.shield.projectJavaCesi.entity.employee;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String ref;
	private String fucntion;
	private Date startDate;
	private Date endDate;
	private Boolean active;
	private Boolean archive;
	private String email;
	private String password;

	public enum Contract {
		OPEN_ENDED_CONTRACT, FIXED_TERM_CONTRACT, APPRENTICESHIP, INTERNSHIP, NOT_CONCERNED;

	}

	private Contract contract;

	@ManyToOne
	@JoinColumn(name = "employee_department_id", referencedColumnName = "id")
	private EmployeeDepartment employeeDepartment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getFucntion() {
		return fucntion;
	}

	public void setFucntion(String fucntion) {
		this.fucntion = fucntion;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean isArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

}
