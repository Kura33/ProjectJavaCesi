package com.shield.projectJavaCesi.entity.being;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
	
	
	//@OneToMany(mappedBy = "organisation")
	//private List<CivilOnOrganisation> civilOnOrganisation = new ArrayList<>();
		
	@ManyToMany
	@JoinTable(name = "civil_on_organisation", joinColumns = @JoinColumn(name = "civil_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "organisation_id", referencedColumnName = "id"))
	private List<Civil> civils = new ArrayList();
	

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

	public List<Civil> getCivils() {
		return civils;
	}

	public void setCivils(List<Civil> civils) {
		this.civils = civils;
	}
	
}