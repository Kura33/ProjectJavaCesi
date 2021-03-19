package com.shield.projectJavaCesi.entity.being;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("0")
public class Civil extends Being {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private String gender;
	
	public static final String MR = "M";
	public static final String MME = "Mme";

	public enum Gender {
		MR, MME;
	}
	
	//@ManyToMany
	//@JoinTable(name = "civil_on_organisation", joinColumns = @JoinColumn(name = "organisation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "civil_id", referencedColumnName = "id"))
	@OneToMany(mappedBy = "civil")
	private List<Organisation> organisation = new ArrayList<>();
	
	public void addOrganisation(Organisation organisation) {
		this.organisation.add(organisation);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return organisation;
	}

	public void setOrganisation(List<Organisation> organisation) {
		this.organisation = organisation;
	}
	
}