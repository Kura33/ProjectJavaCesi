package com.shield.projectJavaCesi.entity.being;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.shield.projectJavaCesi.entity.event.Mission;


@Entity
@DiscriminatorValue("ORGANISATION")
public class Organisation extends Being {

	private String name;
	private String siret;
	private String socialSecurityNumber;
	
	@ManyToMany
	@JoinTable(name = "civil_on_organisation", joinColumns = @JoinColumn(name = "mission_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "incident_id", referencedColumnName = "id"))
	private List<Mission> mission = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
	  name = "STUDENTS_COURSES",
	  joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"),
	  inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
	)
	private List<Civil> civils;
	
}