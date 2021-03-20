package com.shield.projectJavaCesi.entity.being;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@DiscriminatorValue("0")
public class Civil extends Being {

	private String firstname;
	private String lastname;
	private String socialSecurityNumber;
	private String gender;
	
	public static final String MR = "M";
	public static final String MME = "Mme";

	public enum Gender {
		MR, MME;
	}
	
	@ManyToMany
	@JoinTable(name = "civil_on_organisation", joinColumns = @JoinColumn(name = "organisation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "civil_id", referencedColumnName = "id"))
	private List<Organisation> organisations = new ArrayList<>();
	
	public void addOrganisation(Organisation organisation) {
		this.organisations.add(organisation);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Organisation> getOrganisation() {
		return organisations;
	}

//	public void setOrganisation(List<Organisation> organisation) {
//		this.organisations = organisations;
//	}
}