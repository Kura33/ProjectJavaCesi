package com.shield.projectJavaCesi.entity.multipleConnection;

import com.shield.projectJavaCesi.entity.employee.Employee;
import com.shield.projectJavaCesi.entity.event.Incident;
import com.shield.projectJavaCesi.entity.superbeing.Ability;
import com.shield.projectJavaCesi.entity.superbeing.Superbeing;

import java.util.List;

import javax.persistence.*;
import com.shield.projectJavaCesi.entity.being.Being;

@Entity
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String extension;
    private String media; // save as base64

    @ManyToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="superbeing_id", referencedColumnName = "id")
    private Superbeing superbeing;

    @ManyToOne
    @JoinColumn(name="ability_id", referencedColumnName = "id")
    private Ability ability;

    @ManyToOne
    @JoinColumn(name="being_id", referencedColumnName = "id")
    private Being being;
    
    @ManyToOne
    @JoinColumn(name = "incident_id", referencedColumnName = "id")
    private Incident incident;
    
	@OneToMany(mappedBy = "media", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Superbeing getSuperbeing() {
		return superbeing;
	}

	public void setSuperbeing(Superbeing superbeing) {
		this.superbeing = superbeing;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	public Being getBeing() {
		return being;
	}

	public void setBeing(Being being) {
		this.being = being;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}
    
    
}
