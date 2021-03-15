package com.shield.projectJavaCesi.entity.employee;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
		CDI("CDI"), CDD("CDD"), ALTERNANCE("Alternance"), STAGE("Stage"), NOT_CONCERNED("N/C");

		Contract(String string) {
			// TODO Auto-generated constructor stub
		}
	}

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getArchive() {
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

}
