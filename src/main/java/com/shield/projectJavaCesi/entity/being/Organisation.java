package com.shield.projectJavaCesi.entity.being;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.shield.projectJavaCesi.entity.event.Mission;


@Entity(name = "Organisation")
@DiscriminatorValue("1")
public class Organisation extends Being {

	private String name;
	private String siret;
	
	//@ManyToMany
	//@JoinTable(name = "civil_on_organisation", joinColumns = @JoinColumn(name = "civil_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "organisation_id", referencedColumnName = "id"))
	
	@OneToMany(mappedBy = "organisation")
	private List<CivilOnOrganisation> civilOnOrganisation = new ArrayList<>();
	
	public void addCivil(CivilOnOrganisation civilOnOrganisation) {
		this.civilOnOrganisation.add(civilOnOrganisation);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public List<CivilOnOrganisation> getCivilOnOrganisation() {
		return civilOnOrganisation;
	}

	public void setCivilOnOrganisation(List<CivilOnOrganisation> civilOnOrganisation) {
		this.civilOnOrganisation = civilOnOrganisation;
	}
	
	
}